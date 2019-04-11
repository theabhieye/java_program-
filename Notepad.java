import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Notepad implements ActionListener,TextListener,ItemListener
{
    private Frame f;
    private TextArea ta;
    private Button b1,b2;
    private Choice c1,c2,c3;
    private Label l1,l2,l3,l4,l5;
    private Panel p1,p2,p3;
    private Font font;
    Notepad() 
    {
        f=new Frame();
        f.setBounds(0,0,1000,600);
        f.setLayout(new BorderLayout());
        
        ta=new TextArea("",50,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setBackground(Color.GRAY);
        ta.setForeground(Color.WHITE);
        
      //  Font font=new Font("Times",Font.BOLD,18);
        ta.setFont(font);
        ta.setText("Hi Abhi :) start you text here :_...");
        ta.selectAll();
        f.add(ta,BorderLayout.CENTER);
        
        Panel p=new Panel();
        p.setLayout(new FlowLayout(FlowLayout.RIGHT));
        b1=new Button("Open");
        b1.addActionListener(this);
        
        b2=new Button("Save");
        b2.addActionListener(this);
        
        
        p.add(b1);
        p.add(b2);
        
        b1.setForeground(Color.blue);
        b2.setForeground(Color.blue);
        
        // info of word
        Font font1=new Font("Arail",Font.PLAIN,12);
        
        
        p1=new Panel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        l1=new Label("Char:0     ");
        l2=new Label(" ,Line:0      ");
        l3=new Label(" ,Vowels:0    ");
        l4=new Label(" ,UpperCase:0      ");
        l5=new Label(" ,LowerCase:0      ");
        
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        
        l1.setFont(font1);
        l2.setFont(font1);
        l3.setFont(font1);
        l4.setFont(font1);
        l5.setFont(font1);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        
        p2=new Panel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        p2.add(p1);
        p2.add(p);
        p2.setBackground(Color.DARK_GRAY);
        f.add(p2,BorderLayout.SOUTH);

        ta.addTextListener(this);
        
        //selection of fonts
        c1=new Choice();
      //  c1.add("Select Font");
        c1.add("Avenir");
        c1.add("Chalkduster");
        c1.add("Charter");
        c1.add("Cochin");
        c1.add("Courier");
        
        
        c2=new Choice();
     //   c2.add("Select size");
        c2.add("10");
        c2.add("12");
        c2.add("14");
        c2.add("16");
        c2.add("18");
        c2.add("20");
        c2.add("22");
        c2.add("24");
        c2.add("26");
        c2.add("28");
        c2.add("30");
        c2.add("32");
        c2.add("34");
        c2.add("36");
        c2.add("38");
        c2.add("40");
        
        p3=new Panel();
        p3.setLayout(new GridLayout(1,3));
        p3.add(c1);
        p3.add(c2);
        
        c3=new Choice();
        c3.add("Font.BOLD");
        c3.add("Font.PLAIN");
        c3.add("Font.ITALIC");
        p3.add(c3);
        f.add(p3,BorderLayout.NORTH);
        
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        
        f.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e) 
    {
        Object o=e.getSource();
        //b1=open button
        if(o==b1)
        {
            System.out.println("Open clicked");
            fileOut();
        }
        //b2=save button
        if(o==b2)
        {
            System.out.println("Save clicked");
            fileIn();
         }
    }
    public void fileOut() 
    {
        try
        {
            FileInputStream fis=new FileInputStream("/Users/apple/Desktop/javaProgram/gui/opps(GUI)/DemoGUI1.java");
            
            byte b[]=new byte[fis.available()];
            fis.read(b);
            //for(int i=0;i<b.length;i++)
              //  System.out.print((char)b[i]);
            String s=new String(b);
            ta.setText(s);
            fis.close();
        }
        catch(IOException i)
        {
            System.out.println("fileNotconnect");
        }
    }
    public void fileIn()
    {
        FileOutputStream fos;
        try
        {
            fos=new FileOutputStream("/Users/apple/Desktop/javaProgram/gui/opps(GUI)/abhi.java");
            
            String s;
            s=ta.getText();
           // System.out.print(ta.getText());
            byte b[];
            b=s.getBytes();
            for(int i=0;i<b.length;i++)
            {       
                //System.out.print((char)b[i]);
                fos.write(b[i]);
            }
            fos.close();
        }
        catch(IOException i)
        {
            System.out.println("File Not connect");
        }
    }
    public void textValueChanged(TextEvent e) 
    {
        String s;
        s=ta.getText();
        //Total number of char
        l1.setText("Char:"+s.length());
        
        //number of line change    
        if(s.indexOf('\n')!=-1)
        {
            int count=0;
            for(int i=0; i<s.length(); i++)
            {    
                if(s.charAt(i) == '\n')
                    count++;
            }
            l2.setText(",Line:"+count);
        }
        //number of Vowel 
        if(s.indexOf('A')!=-1 || s.indexOf('E')!=-1 || s.indexOf('I')!=-1 || s.indexOf('O')!=-1 || s.indexOf('U')!=-1 || s.indexOf('a')!=-1 || s.indexOf('e')!=-1 || s.indexOf('i')!=-1 || s.indexOf('o')!=-1   || s.indexOf('u')!=-1 )
        {
            int count=0;
            for(int i=0; i<s.length(); i++)
            {    
                if(s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'|| s.charAt(i)=='O'||s.charAt(i)=='U'||s.charAt(i)=='a'|| s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'|| s.charAt(i)=='u') {    
                    count++;
                }
            }
            l3.setText(",Vowels:"+count);
        }
        //number of UpperCase char
        
        char c[];
        int COUNT_UPPERCASE=0;
        int COUNT_LOWERCASE=0;
        c=s.toCharArray();
        
        for(int i=0;i<s.length();i++)
        {
            if(c[i]>='A' && c[i]<='Z')
                    COUNT_UPPERCASE++;
            else if(c[i]>='a' && c[i]<='z')
                    COUNT_LOWERCASE++;
        }
        l4.setText(",UpperCase:"+COUNT_UPPERCASE);
        l5.setText(",LowerCase:"+COUNT_LOWERCASE);
    }
    public void itemStateChanged(ItemEvent e)
    {
        Object o;
        o=e.getSource();
        if(o==c1)
        {
             String s=c1.getSelectedItem();        
             Font font=new Font(s,Font.BOLD,18);
        }
        else if(o==c3)
        {
           // String s=c3.getSelectedItem();
            //System.out.println(s);
            
            if(c3.getSelectedItem().equals(Font.BOLD))
            font=new Font("Avenir",Font.BOLD,18);
            else if(c3.getSelectedItem().equals(Font.ITALIC))
            font=new Font("Avenir",Font.ITALIC,18);
            else if(c3.getSelectedItem().equals(Font.PLAIN))
            font=new Font("Avenir",Font.PLAIN,18);
        }
        ta.setFont(font);
     
    }
    public static void main(String arg[])
    {
        Notepad n1=new Notepad();
    }
}

