import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
public class Calculator extends JFrame {
    private JTextField JTextField1;
   
    private JButton num1;
    private JButton num2;
    private JButton num3;
    private JButton num4;
    private JButton num5;
    private JButton num6;
    private JButton num7;
    private JButton num8;
    private JButton num9;
    private JButton num0;
    private JButton plus;
    private JButton minus;
    private JButton multy;
    private JButton pow;
    private JButton eq;
    private JButton sin;
    private JButton a;
    private JButton b;
    private JButton log;
    private JButton dat;
     public Calculator()
   {
      super( "Calculator" );
      setLayout( new FlowLayout() ); // set frame layout
     
      JTextField1 =new JTextField("",19);
      JTextField1.setBackground(Color.yellow);

      add(JTextField1);
      num1 = new JButton( "1" ); // button with text
      add( num1 ); // add plainJButton to JFrame
      num2 = new JButton( "2" );
      add( num2 );
       num3 = new JButton( "3" );
      add( num3 );
       num4 = new JButton( "4" );
      add( num4 );
       num5 = new JButton( "5" );
      add( num5 );
       num6 = new JButton( "6" );
      add( num6 );
      num7 = new JButton( "7" );
      add( num7 );
      num8 = new JButton( "8" );
      add( num8 );
      num9 = new JButton( "9" );
      add( num9 );
      num0 = new JButton( "0" );
      add( num0 );
      minus = new JButton( "-" );
      add( minus );
      plus = new JButton( "+" );
      add( plus );
      pow = new JButton( "^" );
      add( pow );
      multy= new JButton( "*" );
      add( multy );
      eq= new JButton( "=" );
      add( eq );
      sin= new JButton( "sin" );
      add( sin );
      a= new JButton( "(" );
      add( a );
      b= new JButton( ")" );
      add( b );
      log= new JButton( "log" );
      add( log );
      dat= new JButton( "." );
      add( dat );
      // create new ButtonHandler for button event handling
      ButtonHandler handler = new ButtonHandler();
      num1.addActionListener( handler );
      num2.addActionListener( handler );
      num3.addActionListener( handler );
      num4.addActionListener( handler );
      num5.addActionListener( handler );
      num6.addActionListener( handler );
      num7.addActionListener( handler );
      num8.addActionListener( handler );
      num9.addActionListener( handler );
      num0.addActionListener( handler );
      plus.addActionListener( handler );
      pow.addActionListener( handler );
      minus.addActionListener( handler );
      multy.addActionListener( handler );
      eq.addActionListener( handler );
      sin.addActionListener( handler );
      a.addActionListener( handler );
      b.addActionListener( handler );
      log.addActionListener( handler );
      dat.addActionListener( handler );
      JTextField1.addActionListener( handler );


   } // end ButtonFrame constructor




    private  int i=0;
    private  String array[]=new String[100];
    private static  String r="";
    private static String stg="";
//******************************************************************************
   // inner class for button event handling
   private class ButtonHandler implements ActionListener
   {
      // handle button event
      public void actionPerformed( ActionEvent event )
      {
          array[i]=event.getActionCommand();
         
                stg=stg+ array[i];
          JTextField1.setText(stg);
         
          r=JTextField1.getText();
          System.out.println(r);
           JTextField1.setText(Calculator.result());
          if(array[i].equals("=")){
              int temp=i;
              for(i=0;i<=temp;i++){
                   r=r+array[i];
              }
              Calculator.result();
              JTextField1.setText(Calculator.result());
              
          }

          i++;

      } // end method actionPerformed
   } // end private inner class
  //****************************************************************************
   public static String getstr(){
       return stg;
   }


//******************************************************************************
   public static String a(String str){
        while (str.contains("sin")){
             str=sin(str);
             if(str.indexOf("-")==0)
                 break;
       }

        while (str.contains("log"))
             str=log(str);
        while (str.contains("^"))
             str=power(str);
        while (str.contains("*"))
             str=multiplay(str);
        while (str.contains("/"))
             str=devide(str);
        while (str.contains("%"))
             str=remain(str);
        while (str.contains("-")){
             str=Count2(str);
             if(str.indexOf("-")==0)
                 break;
       }
       while (str.contains("+"))
             str=Count2(str);

       return str;
       }
//******************************************************************************
public static String parantes(String str){
   while(str.contains("(")) {
      int i = str.indexOf('(');
      int j = str.indexOf(')');
      String str1 = str.substring(i + 1, j);
      str=str.replace(str.substring(str.indexOf("("), str.indexOf(")") + 1),a(str1));
    }
    return str;
}
//******************************************************************************
   static String firstnumber(String str,int b){
     int j=0;
      b--;
    while(str.charAt(b)>='0'&& str.charAt(b)<='9'||str.charAt(b) == '.'){
      b--;
      j++;
      if(b==-1)
      break;
        }
     b++;
     String str1= str.substring(b , b+j);
     //double num1=Double.parseDouble(str1);
     return str1;

   }
//******************************************************************************
    static String  secondnumber(String str,int b){
        int j=0;
        b++;
        while(str.charAt(b)>='0'&& str.charAt(b)<='9'||str.charAt(b) == '.'){
          b++;
          j++;
          if(b >str.length()-1)
             break;
                }

          String str2= str.substring(b-j, b);
          //double num2=Double.parseDouble(str2);
          return str2;
       }
 //*****************************************************************************
         public static double integerRight(String str, int q, int i) {
        String str1 = str.substring(q + 1, i);
        double b = Double.valueOf(str1);
        return b;
    }

    public static String Count2(String str) {
        double c = 0;
        int i = 0;
        char j1 = 0, j = 0, k = 0;
        for (i = 1; i < str.length(); i++) {
            j = str.charAt(i);
            if (j == '+' || j == '-') {
                break;
            }
        }
        if (i == str.length()) {
            System.exit(0);
        }
        j1 = str.charAt(i + 1);
        if (j1 == '+' || j1 == '-') {
            if (j == j1) {
                String str1 = str.substring(i, i + 2);
                str = str.replace(str1, "+");
            } else {
                String str1 = str.substring(i, i + 2);
                str = str.replace(str1, "-");
            }
        }
        double a =Double.parseDouble( firstnumber(str, i));
        int q = i;
        for (i += 1; i < str.length(); i++) {
            k = str.charAt(i);
            if (k == '+' || k == '-') {
                break;
            }
        }
        double b = integerRight(str, q, i);
        if (str.charAt(0) == '-') {
            if (str.charAt(q) == '-') {
                c = a + b;
                c = -c;
            } else {
                c = b - a;
            }
        } else {
            if (str.charAt(q) == '+') {
                c = a + b;
            }
            if (str.charAt(q) == '-') {
                c = a - b;
            }
        }
        str = str.replace(str.substring(0, i), String.valueOf(c));
        return str;
    }
    //****************************************************************************


    public static String add(String str){
       int plus=str.indexOf("+");
       double add=Double.parseDouble(firstnumber( str,plus))+Double.parseDouble(secondnumber( str,plus));
       String   m=String.valueOf(add);
       //String   mm=String.valueOf(firstnumber( str,plus))+"+"+String.valueOf(secondnumber( str,plus));
       str=str.replace(firstnumber( str,plus)+"+"+secondnumber( str,plus),m);
       //System.out.println(str);
       return str;
    }
//******************************************************************************
   public static String  multiplay(String str){
       int multy=str.indexOf("*");
       double multyplay=Double.parseDouble(firstnumber( str,multy))*Double.parseDouble(secondnumber( str,multy));
       String   m=String. valueOf(multyplay);

       str=str.replace(firstnumber( str,multy)+"*"+secondnumber( str,multy),m);
       return str;
    }
//******************************************************************************
  public static String  power(String str){
       int pow=str.indexOf("^");
       Double power=(Double)(Math.pow(Double.parseDouble(firstnumber( str,pow)), Double.parseDouble(secondnumber( str,pow)) ));
       String   m=String. valueOf(power);

       str=str.replace(firstnumber( str,pow)+"^"+secondnumber( str,pow),m);
       return str;
    }
//******************************************************************************
  public static String  subtract(String str){
       int sub=str.indexOf("-");
       double subtract=Double.parseDouble(firstnumber( str,sub))-Double.parseDouble(secondnumber( str,sub));
       String   m=String. valueOf(subtract);
       str=str.replace(firstnumber( str,sub)+"-"+secondnumber( str,sub),m);
       return str;
    }
//******************************************************************************
  public static String  devide(String str){
       int div=str.indexOf("/");
       double devide=Double.parseDouble(firstnumber( str,div))/Double.parseDouble(secondnumber( str,div));
       String   m=String. valueOf(devide);
       str=str.replace(firstnumber( str,div)+"/"+secondnumber( str,div),m);
       return str;
    }
//******************************************************************************
  public static String  remain(String str){
       int r=str.indexOf("%");
       double remain=Double.parseDouble(firstnumber( str,r))%Double.parseDouble(secondnumber( str,r));
       String   m=String. valueOf(remain);
       str=str.replace(firstnumber( str,r)+"%"+secondnumber( str,r),m);
       return str;
    }
//******************************************************************************
public static String  sin(String str){
       int r=str.indexOf("sin");
       r=r+2;
       Double sin=Math.sin(Double.parseDouble(secondnumber( str,r))*Math.PI/180);
       String   m=String. valueOf(sin);
       String   mm="sin"+secondnumber( str,r);
       str=mm.replace(mm,m);
       return str;
    }
//******************************************************************************
public static String  log(String str){
       int r=str.indexOf("log");
       r=r+2;
       Double log=Math.log10(Double.parseDouble(secondnumber( str,r)));
       String   m=String. valueOf(log);
       String   mm="log"+secondnumber( str,r);
       str=mm.replace(mm,m);
       return str;
    }
//******************************************************************************
public static String result(){
String str=Calculator.getstr();

     while(str.endsWith("=")){
           str=str.replace("=","");
           str=Calculator.parantes(str);
           str=Calculator.a(str);
           //System.out.println(str);
       }
    return str;
    }
}
