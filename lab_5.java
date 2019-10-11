import java.util.*;
import java.io.IOException;
import java.io.*;

class MyGenericList <T> {
    private ArrayList<T> myList;
    public MyGenericList() {
        myList = new ArrayList <T>();
    }
    public void add(T o) {
        myList.add(o);
    }
    public T get(int i) {
        return myList.get(i);
    }
}




////
class snakeBiteException extends Exception{
    public snakeBiteException (String msg){
        super(msg);
    }
}
class CricketBiteException extends Exception{
    public CricketBiteException (String msg){
        super(msg);
    }
}
class VultureBiteException extends Exception{
    public VultureBiteException (String msg){
        super(msg);
    }
}
class TrampolineException extends Exception{
    public TrampolineException (String msg){
        super(msg);
    }
}
class GameWinnerException extends Exception{
    public GameWinnerException (String msg){
        super(msg);
    }
}
////

abstract class tile{
    protected int effect;
    protected int type;
    tile(int effect ,int type){
        this.effect = effect;
        this.type =type;
    }

    abstract void move() throws Exception;
}

class snake extends tile{
    snake(int eff){
        super(eff ,1);
    }

    @Override
    void move() throws snakeBiteException {
        throw  new snakeBiteException(" snake is there");
    }
}

class vulture extends tile{
    vulture(int eff){
        super(eff,2);
    }

    @Override
    void move() throws VultureBiteException {
        throw new VultureBiteException(" vulture is there");
    }
}

class cricket extends tile{
    cricket(int eff){
        super(eff, 3);
    }

    @Override
    void move() throws  CricketBiteException {
        throw new CricketBiteException(" cricket is there");

    }
}

class white extends tile{
    white(int eff){
        super(eff,5) ;
    }

    @Override
    void move() {
        return;
    }
}

class trampoline extends tile{
    trampoline(int eff){
        super(eff ,4);
    }

    @Override
    void move() throws TrampolineException {
        throw new TrampolineException(" trampoline is here");

    }
}

class dicey {
    int roll() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}





class board implements Serializable{
   static ArrayList<Integer> map;
    board(){
        map = new ArrayList<>();
    }


    private void makey(int typ,int qun){
        for(int i = 0 ; i < qun; i++){
            map.add((typ));
        }
    }

    void make(int f1,int f2,int f3,int f4, int f5){
        makey(1,f1);
        makey(2,f2);
        makey(3,f3);
        makey(4,f4);
        makey(5,f5);
        Collections.shuffle(map);
    }
}
class game5 implements Serializable{
    private String name;
    boolean onlyonce;
    private int wherernow;
    private int gridsize;
    private board boardgame;
    private int[] af;
    private int[] gh;
    game5(String it, int t) {
        onlyonce = true;
        name = it;
        gridsize = t;
        af = new int[13];
        af[0] = 0;
        wherernow = 1;
        gh =new int[3];
        for(int  i = 0; i <3; i++)
            gh[i]=0;
    }


    void start() throws IOException, GameWinnerException {
        MyGenericList<Integer> boardgame = new MyGenericList<>();
        MyGenericList<String> boardttype = new MyGenericList<>();

        int f1 =af[0];
        int f2, f3, f4, f5, op1, op2, op3, op4, sb, vb,tb, cb;
        if(f1 == 0) {
            sb = 0;
            vb = 0;
            tb = 0;
            cb = 0;
            System.out.println("input the size (greater than 70)");


            f1 = ((int) (Math.random() * (gridsize / 10 - 1))) + 1;
            af[0] = f1;
            f2 = ((int) (Math.random() * (gridsize / 10 - 1))) + 1;
            af[1] = f2;
            f3 = ((int) (Math.random() * (gridsize / 10 - 1))) + 1;
            af[2] = f3;
            f4 = ((int) (Math.random() * (gridsize / 10 - 1))) + 1;
            af[3] = f4;
            f5 = gridsize - f1 - f2 - f3 - f4;
            af[4] = f5;

            boardgame.add(f1);
            boardgame.add(f2);
            boardgame.add(f3);
            boardgame.add(f4);

            op1 = -(((int) (Math.random() * (10 - 1))) + 1);
            af[5] = op1;
            op2 = -(((int) (Math.random() * (10 - 1))) + 1);
            af[6] = op2;
            op3 = -(((int) (Math.random() * (10 - 1))) + 1);
            af[7] = op3;
            op4 = ((int) (Math.random() * (10 - 1))) + 1;
            af[8] = op4;
        }
        else{
            f2= af[1]; f3 = af[2]; f4 =af[3]; f5 =af[4]; op1 = af[5]; op2 = af[6]; op3 =af[7]; op4 = af[8];
            sb =af[9]; vb = af[10]; tb = af[11]; cb =af[12];
        }

        boardttype.add("white");
        System.out.println(">>Setting up the race track...\n" +
                ">>Danger: There are " + f1 + " " + f3 + " " + f2 + "  numbers of Snakes, Cricket, vultures " +
                "and Vultures respectively on your track!");

        System.out.println(">>Danger: Each Snake, Cricket, and Vultures can throw you back by " + -op1 + " " + -op3 + " " + -op2 +
                " number of Tiles respectively! //");

        System.out.println(">>Good News: There are " + f4 + " number of Trampolines on your track!");

        System.out.println(">>Good News: Each Trampoline can help you advance by " + op4 + " number of Tiles");

        System.out.println(">>Starting the game with " + name + " at Tile-1\n" +
                ">>Control transferred to Computer for rolling the Dice for " + name + "\n" +
                ">>Hit enter to start the game");

        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dicey dice = new dicey();
        int check3 = 0;
        int count = 1;
        board playingBoard = new board();
        playingBoard.make(f1, f2, f3, f4, f5);
        while (true) {
            Scanner inputo = new Scanner(System.in);
            if(0.25*gridsize<=wherernow && 0.25*gridsize +6>=wherernow && gh[0] == 0){
                gh[0] =1;
                System.out.println("want to save (write the number)\n1. yes and exit\n 2. no and continue");
                int uio = inputo.nextInt();
                if(uio == 1){
                    serialize(this);
                    System.exit(0);
                }
            }
            if(0.5*gridsize<=wherernow && 0.5*gridsize +6>=wherernow && gh[1] == 0){
                gh[1] =1;
                System.out.println("want to save (write the number)\n1. yes and exit\n 2. no and continue");
                int uio = inputo.nextInt();
                if(uio == 1){
                    serialize(this);
                    System.exit(0);
                }
            }
            if(0.75*gridsize<=wherernow && 0.75*gridsize +6>=wherernow && gh[2] == 0){
                gh[2] =1;
                System.out.println("want to save (write the number)\n1. yes and exit\n 2. no and continue");
                int uio = inputo.nextInt();
                if(uio == 1){
                    serialize(this);
                    System.exit(0);
                }
            }
            System.out.println("roll = " + count);
            System.out.println("current place = " + wherernow);
            int ro = dice.roll();
            if (ro != 6 && onlyonce) {
                System.out.println("pal you need a six to get out ");
                count++;
                continue;
            }

            onlyonce = false;
            wherernow += ro;
            count++;
            if (wherernow > gridsize) {
                if (check3 > 3) {
                    System.out.println("trampoline = " + tb + "\nsnake bites = " + sb + "\n vulture bite =" + vb + "\n crciket bite = " + cb + "\n");
                    throw new GameWinnerException(name + " wins the race ");


                }
                check3++;
                wherernow -= ro;
                continue;
            }
            if (wherernow == gridsize) {
                System.out.println("trampoline = " + tb + "\nsnake bites = " + sb + "\n vulture bite =" + vb + "\n crciket bite = " + cb + "\n");
                    throw new GameWinnerException(name + " wins the race ");



            }


            int temp1 = board.map.get(wherernow - 1);
            tile cur;
            ////
            if (temp1 == 1 && wherernow > 10) {
                sb++;
                cur = new snake(op1);

            } else if (temp1 == 2 && wherernow > 10) {
                vb++;
                cur = new vulture(op2);

            } else if (temp1 == 3 && wherernow > 10) {
                cb++;
                cur = new cricket(op3);

            } else if (temp1 == 4 && wherernow > 10) {
                tb++;
                cur = new trampoline(op4);

            } else {
                System.out.println("it is a white tile");
                cur = new white(0);

            }
            wherernow += cur.effect;
            ////

            try {

                cur.move();
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }

        }

    }

    @Override
    public boolean equals(Object o1){
        game5 o2 = (game5) o1;
        if(this.name.equals(o2.name) && this.gridsize == o2.gridsize)
        return true;
        else
            return false;
    }

    public static void serialize(game5 s1) throws IOException {

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(
                    new FileOutputStream(s1.name+ ".txt"));
            out.writeObject(s1);
        } finally {
            out.close();
        }
    }


}
public class lab_5 {
    public static void main (String[] args)throws IOException ,ClassNotFoundException, GameWinnerException {
        Scanner take =new Scanner(System.in);
        System.out.println("1. new player \n2. exsisting player");
        int  number =take.nextInt();
        String  name = "shailesh";
        switch (number){
            case 1:
                System.out.println("enter your name");
                boolean naamleliyakya = true;
                while(naamleliyakya){
                    try {
                        Scanner input = new Scanner(System.in);
                        name = input.next();
                        naamleliyakya =false;
                    }
                    catch (InputMismatchException e){
                        System.out.println("wrong input\n re enter the name");
                    }
                    System.out.println("grid size ..<more than 90> ??");
                    int gridsize =100;
                    boolean boolGrideSize = true;
                    while(boolGrideSize){
                        try{
                            Scanner input = new Scanner(System.in);
                            gridsize = input.nextInt();
                            boolGrideSize = false;
                        }
                        catch (InputMismatchException e){
                            System.out.println(" wrong input \n re enter the size");
                        }
                    }
                    game5 fi = new game5(name,gridsize);
                    try {
                        fi.start();
                    }
                    catch (GameWinnerException e){
                        System.out.println(e.getMessage());
                    }

                }
                break;
            case 2:
                System.out.println("enter the saved name");
                String so = take.next();
                game5 fi  = deserialize(so);
                fi.start();
                break;
        }

    }

     public static game5 deserialize(String s) throws IOException, ClassNotFoundException {
         ObjectInputStream in = null;
        try {
            in = new ObjectInputStream (
               new FileInputStream(s+".txt"));
             game5 s1 = (game5) in.readObject();
             return s1;
            }
        finally {
            in.close();
            }
        }
}
