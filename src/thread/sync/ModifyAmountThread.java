package thread.sync;

public class ModifyAmountThread extends Thread{
    private CommonCalculate calc;
        private boolean flag;

    public ModifyAmountThread(CommonCalculate calc,boolean flag){
            this.calc=calc;
            this.flag=flag;
        }

        @Override
        public void run() {
        for (int i=0;i<1000;i++){
            if(flag){
                calc.plus(1);
                calc.addInterest(1);
            }else{
                calc.minus(1);
            }

        }
    }
}
