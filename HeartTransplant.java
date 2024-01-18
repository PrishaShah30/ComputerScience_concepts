public class HeartTransplant {
    private Patient[] patients;
    private SurvivabilityByAge survivabilityByAge;
    private SurvivabilityByCause survivabilityByCause;

    public HeartTransplant() {
        patients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    public SurvivabilityByCause getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    public void readPatients(int numberOfLines) {
        this.patients = new Patient[numberOfLines];
        for (int i = 0; i < patients.length; i++) {
            int id = StdIn.readInt(), ethnicity = StdIn.readInt(), gender = StdIn.readInt(), age = StdIn.readInt(),
                    cause = StdIn.readInt(), urgency = StdIn.readInt(), soh = StdIn.readInt();
            patients[i] = new Patient(id, ethnicity, gender, age, cause, urgency, soh);
        }
    }

    public void readSurvivabilityByAge(int numberOfLines) {
        this.survivabilityByAge = new SurvivabilityByAge();
        for (int i = 0; i < numberOfLines; i++) {
            int age = StdIn.readInt(), year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByAge.addData(age, year, rate);
        }
    }

    public void readSurvivabilityByCause(int numberOfLines) {
        this.survivabilityByCause = new SurvivabilityByCause();
        for (int i = 0; i < numberOfLines; i++) {
            int cause = StdIn.readInt(), year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByCause.addData(cause, year, rate);
        }
    }

    public Patient[] getPatientsWithAgeAbove(int age) {
        int count = 0;
        for (int i = 0; i < patients.length; i++)
            if (patients[i].getAge() > age)
                count++;
        if (count == 0)
            return null;
        Patient[] patientAboveAge = new Patient[count];
        count = 0;
        for (int i = 0; i < patients.length; i++)
            if (patients[i].getAge() > age) {
                patientAboveAge[count] = patients[i];
                count++;
            }
        return patientAboveAge;
    }

    public Patient[] getPatientsByHeartConditionCause(int cause) {
        int count = 0;
        for (int i = 0; i < patients.length; i++)
            if (patients[i].getCause() == cause)
                count++;
        if (count == 0)
            return null;
        Patient[] patientWithCause = new Patient[count];
        count = 0;
        for (int i = 0; i < patients.length; i++)
            if (patients[i].getCause() == cause) {
                patientWithCause[count] = patients[i];
                count++;
            }
        return patientWithCause;
    }

    public Patient[] getPatientsByUrgency(int urgency) {
        int count = 0;
        for (int i = 0; i < patients.length; i++)
            if (patients[i].getUrgency() == urgency)
                count++;
        if (count == 0)
            return null;
        Patient[] patientByUrgency = new Patient[count];
        count = 0;
        for (int i = 0; i < patients.length; i++)
            if (patients[i].getUrgency() == urgency) {
                patientByUrgency[count] = patients[i];
                count++;
            }
        return patientByUrgency;
    }

    public Patient getPatientForTransplant() {
        double maxSuccess = 0;
        int index = -1;
        for (int i = 0; i < patients.length; i++)
            if (patients[i].getUrgency() == 9 && patients[i].getNeedHeart() == true
                    && survivabilityByCause.getRate(patients[i].getCause(), 5) > maxSuccess) {
                maxSuccess = survivabilityByCause.getRate(patients[i].getCause(), 5);
                index = i;
            }
        if (index != -1) {
            patients[index].setNeedHeart(false);
            return patients[index];
        } else
            return patients[index];
    }
}