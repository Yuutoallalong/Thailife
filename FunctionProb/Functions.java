public class Functions {

    public static double CommissionRate(int age,int year){
        if (age < 0 || age > 60){
            return 0.0; // invalid age
        }

        if (year <= 0){
            return 0.0; // invalid year
        }
        
        if (year == 1){
            return 2.0;
        }else if (year == 2){
            return (age <= 50) ? 1.0 : 2.0;
        }else if (year == 3){
            return 1.0;
        }else{
            return 0.0;
        }
    }

    public static double OverridingRate(int age, boolean isAnnual){
        if (age < 0 || age > 60){
            return 0.0; // invalid age
        }

        if (age <= 50){
            return (isAnnual) ? 20.0 : 16.0;
        }else{
            return 13.0;
        }
    }

    //test output
    public static void main(String[] args) {
        System.out.println("Commission Rate (Age 25, Year 1): " + CommissionRate(25, 1));
        System.out.println("Commission Rate (Age 70, Year 1): " + CommissionRate(70, 1));
        System.out.println("Commission Rate (Age 25, Year 4): " + CommissionRate(25, 4));

        System.out.println("Overriding Rate (Age 25, Annual): " + OverridingRate(25, true));
        System.out.println("Overriding Rate (Age 70, Non-Annual): " + OverridingRate(70, false));
    }

}
