public class CEO_Data {
    public static void main(String[] args) {
        var ceoData = new A1Q2Data();

        ceoData.totalAverageCompensation(ceoData.getSALARIES(), ceoData.getAWARDS(), ceoData.getOTHERS());

        ceoData.aboveAverage(ceoData.getCOMPANIES(), ceoData.getSALARIES(), ceoData.getAWARDS(), ceoData.getOTHERS());

        ceoData.trivialSalaries(ceoData.getCOMPANIES(), ceoData.getSALARIES());

        ceoData.awardsExceedsCompensation(ceoData.getSALARIES(), ceoData.getAWARDS(), ceoData.getOTHERS());

        ceoData.allInfo(ceoData.getCOMPANIES(), ceoData.getSALARIES(), ceoData.getAWARDS(), ceoData.getOTHERS());
    }
}


