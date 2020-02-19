public class DrawLogo {
    private int num;
    private int modifier;
    private int secondDashesBottom;
    private int midStarsBottom;

    DrawLogo(int num){
        this.num = num;
        this.modifier = num - (num / 2);
        this.secondDashesBottom = 1;
        this.midStarsBottom = (num*2) - 1;
    }

    //draws the specified character num number of times
    private static void drawChar(char character, int num){
        for(int curr = 0; curr < num; curr++){
            System.out.print(character);
        }
    }

    //draws the first num - (num / 2) top rows 
    private void drawTop(){
        for(int row = 0; row < modifier; row++){
            //drawing the top row using recursion; can also create as many Ms as wanted by changing the counter
            recursionDrawTop(row, 2);
            System.out.println();
        }
    }

    //draws a top row depending on the number of the row
    private void drawRowTop(int row){
        for(int total = 0; total < 5; total++){
            if(total == 2){
                drawChar('-', num - row*2);
            }
            else if(total % 2 == 0){
                drawChar('-', num - row);
            }
            else{
                drawChar('*', num + row*2);
            }
        }
    }

    //draws the top row using recursion
    private void recursionDrawTop(int row, int counter){
        if(counter == 0)
            return;
        else
        {
            drawRowTop(row);
        }
        recursionDrawTop(row, --counter);
    }

    //draws all of the bottom rows, save for the last one; starts from num - (num / 2)
    private void drawBottom(){
        for(int row = modifier; row < num; row++){
            //drawing the top row using recursion
            recursionDrawBottom(row, 2);

            System.out.println();
            secondDashesBottom += 2;
            midStarsBottom -= 2;
        }
    }

    //draws a bottom row depending on the number of the row
    private void drawRowBottom(int row){
        for(int total = 0; total < 7; total++){
            switch (total){
                case 0:
                case 6:
                    drawChar('-', num - row);
                    break;
                case 1:
                case 5:
                    drawChar('*', num);
                    break;
                case 2:
                case 4:
                    drawChar('-', secondDashesBottom);
                    break;
                default:
                    drawChar('*', midStarsBottom);
                    break;
            }
        }
    }

    //draws the top row using recursion
    private void recursionDrawBottom(int row, int counter){
        if(counter == 0)
            return;
        else
        {
            drawRowBottom(row);
        }
        recursionDrawBottom(row, --counter);
    }

    //draws the last row
    public void drawLastRow(){
        for(int times = 0; times < 2; times++){
            for(int total = 0; total < 5; total++){
                if(total == 2){
                    drawChar('*', midStarsBottom);
                }
                else if(total % 2 == 0){
                    drawChar('*', num);
                }
                else{
                    drawChar('-', secondDashesBottom);
                }
            }
        }
        System.out.println();
    }

    //draws the logo using num as the parameter
    public boolean drawLogo(){
        drawTop();
        drawBottom();
        drawLastRow();
        return true;
    }
}
