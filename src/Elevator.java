public class Elevator
{
    private int numberOfFloors;
    private String historyLift;
    private boolean isKnownFloor = false;
    private int currFlor;

    public Elevator(int numberOfFloors, String historyLift)
    {
        this.numberOfFloors = numberOfFloors;
        this.historyLift = historyLift;
    }

    public boolean checkHistoryLift()
    {
        int upInARow = 0;
        int downInARow = 0;

        int upCounter = 0;
        int downCounter = 0;

        for (char ch : historyLift.toCharArray())
        {
            if(isKnownFloor)
            {
                if(ch == 'G')
                {
                    currFlor++;
                }else if(ch == 'D')
                {
                    currFlor--;
                }else
                    return false;

                if(currFlor > numberOfFloors || currFlor < 0)
                    return false;
            }else
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

                if(downInARow == numberOfFloors)
                    setCurrFlor(0);

                if(upInARow == numberOfFloors)
                    setCurrFlor(numberOfFloors);

                if(Math.abs(upCounter - downCounter) == numberOfFloors)
                {
                    if(downCounter > upCounter)
                        setCurrFlor(0);
                    else
                        setCurrFlor(numberOfFloors);
                }
            }
        }

        return true;
    }

    private void setCurrFlor(int currFlor)
    {
        isKnownFloor = true;
        this.currFlor = currFlor;
    }
}
