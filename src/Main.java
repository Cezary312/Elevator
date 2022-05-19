public class Main
{

    public static void main(String[] args)
    {
        System.out.println("numberOfFloors: 3, historyLift: GGGDDD, should be true: " + checkHistoryLift(3, "GGGDDD"));
        System.out.println("numberOfFloors: 3, historyLift: GGGDDDD, should be false: " + checkHistoryLift(3, "GGGDDDD"));
        System.out.println("numberOfFloors: 3, historyLift: GGGGDDD, should be false: " + checkHistoryLift(3, "GGGGDDD"));
        System.out.println("numberOfFloors: 3, historyLift: DDDD, should be false: " + checkHistoryLift(3, "DDDD"));
        System.out.println("numberOfFloors: 3, historyLift: D, should be true: " + checkHistoryLift(3, "D"));
        System.out.println("numberOfFloors: 3, historyLift: GGDGGG, should be false: " + checkHistoryLift(3, "GGDGGG"));
        System.out.println("numberOfFloors: 3, historyLift: GGDDD, should be true: " + checkHistoryLift(3, "GGDDD"));
        System.out.println("numberOfFloors: 3, historyLift: DDDGG, should be true: " + checkHistoryLift(3, "DDDGG"));

        System.out.println("numberOfFloors: 2, historyLift: DGDGDGDGDGDG, should be true: " + checkHistoryLift(2, "DGDGDGDGDGDG"));
        System.out.println("numberOfFloors: 2, historyLift: DDGDD, should be false: " + checkHistoryLift(2, "DDGDD"));
        System.out.println("numberOfFloors: 3, historyLift: GGGDDGGG, should be false: " + checkHistoryLift(3, "GGGDDGGG"));
        System.out.println("numberOfFloors: 3, historyLift: GGGDDGG, should be true: " + checkHistoryLift(3, "GGGDDGG"));
    }

    static boolean checkHistoryLift(int numberOfFloors, String historyLift)
    {
        int upInARow = 0;
        int downInARow = 0;

        int upCounter = 0;
        int downCounter = 0;

        for (char ch : historyLift.toCharArray())
        {
            if(ch == 'G')
            {
                upCounter++;
                upInARow++;
                downInARow = 0;
            }else if(ch == 'D')
            {
                downCounter++;
                downInARow++;
                upInARow = 0;
            }else
            {
                return false;
            }

            if(downInARow > numberOfFloors || upInARow > numberOfFloors)
                return false;

            if(Math.abs(upCounter - downCounter) > numberOfFloors)
                return false;
        }

        return true;
    }
}
