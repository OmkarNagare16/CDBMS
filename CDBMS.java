import java.util.*;

class Student {
    public String Sname;
    public int Marks;
    public int Rollno;

    public static int Generator;

    static {
        Generator = 0;
    }

    public Student(String str, int no) {
        this.Sname = str;
        this.Marks = no;
        Generator++;
        this.Rollno = Generator;
    }

    public void Display() {
        System.out.println("Roll No : " + Rollno + " Name : " + Sname + " Marks : " + Marks);
    }
}

class DBMS {
    public LinkedList<Student> lobj;

    public DBMS() {
        lobj = new LinkedList();
    }

    public void StartDBMS() {
        System.out.println("Omkar Customised DBMS started succesfully...");

        Scanner sobj = new Scanner(System.in);
        String Query = " ";
        int QuerySize = 0;

        while (true) {

            System.out.print("Omkar DBMS : > ");
            Query = sobj.nextLine();

            String Tokens[] = Query.split(" ");
            QuerySize = Tokens.length;

            if (QuerySize == 1) {

                if ("help".equals(Tokens[0])) {

                    System.out.println("This application is used to demonstrate the fetures of customiesed dbms.");
                    System.out.println("Display all data : select * from student");
                    System.out.println("Display Specific record : select * from student where Rollno = 1");
                    System.out.println("Display Specific record : select * from student where Sname = Omkar");
                    System.out.println("Insert new recored : insert into student values Name Marks");
                    System.out.println("Delete from record : delete from student where Rollno = 1");
                    System.out.println("Delete from record : delete from student where Sname = Pratik");
                    System.out.println("Aggrigate function Sum : select sum marks from student");
                    System.out.println("Aggrigate function avg : select avg marks from student");
                    System.out.println("Aggrigate function max : select max marks from student");
                    System.out.println("Aggrigate function min : select min marks from student");
                    System.out.println("Terminate the project : exit");

                } else if ("exit".equals(Tokens[0])) {
                    System.out.println("Thank you for using our customised DBMS.");
                    break;
                }
            } else if (QuerySize == 4) {
                if ("select".equals(Tokens[0])) {
                    if ("*".equals(Tokens[1])) {
                        DisplayAll();
                    }
                }
            } else if (QuerySize == 5) {
                if ("select".equals(Tokens[0])) {
                    if ("sum".equals(Tokens[1])) {
                        Sum();
                    } else if ("avg".equals(Tokens[1])) {
                        Avg();
                    } else if ("max".equals(Tokens[1])) {
                        Max();
                    } else if ("min".equals(Tokens[1])) {
                        Min();
                    }
                }
            } else if (QuerySize == 6) {
                if ("insert".equals(Tokens[0])) {
                    if ("student".equals(Tokens[2])) {
                        Insert(Tokens[4], Integer.parseInt(Tokens[5]));
                    }
                }
            } else if (QuerySize == 7) {
                if ("delete".equals(Tokens[0])) {
                    if ("Rollno".equals(Tokens[4])) {
                        Delete(Integer.parseInt(Tokens[6]));
                    } else if ("Sname".equals(Tokens[4])) {
                        Delete(Tokens[6]);
                    }

                }

            } else if (QuerySize == 8) {
                if ("select".equals(Tokens[0])) {
                    if ("Rollno".equals(Tokens[5])) {
                        DisplaySpecific(Integer.parseInt(Tokens[7]));
                    } else if ("Sname".equals(Tokens[5])) {
                        DisplaySpecific(Tokens[7]);
                    }
                }
            }

        }
    }

    public void Insert(String str, int no) {
        Student sobj = new Student(str, no);
        lobj.add(sobj);
    }

    public void DisplayAll() {
        for (Student sref : lobj) {
            sref.Display();
        }
    }

    public void DisplaySpecific(int Value) {
        for (Student sref : lobj) {
            if (sref.Rollno == Value) {
                sref.Display();
                break;
            }
        }
    }

    public void DisplaySpecific(String str) {
        for (Student sref : lobj) {
            if (str.equals(sref.Sname)) {
                sref.Display();
                break;
            }
        }
    }

    public void Delete(int no) {
        int index = 0;

        for (Student sref : lobj) {
            if (sref.Rollno == no) {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    public void Delete(String str) {
        int index = 0;

        for (Student sref : lobj) {
            if (str.equals(sref.Sname)) {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    public void Sum() {
        int iSum = 0;

        for (Student sref : lobj) {
            iSum = iSum + (sref.Marks);
        }

        System.out.println("Summation of marks : " + iSum);
    }

    public void Avg() {
        int iSum = 0;

        for (Student sref : lobj) {
            iSum = iSum + (sref.Marks);
        }

        System.out.println("Average of marks : " + (iSum / lobj.size()));
    }

    public void Max() {
        int iMax = 0;

        for (Student sref : lobj) {
            if (iMax < sref.Marks) {
                iMax = sref.Marks;
            }
        }

        System.out.println("Maximum marks are : " + iMax);
    }

    public void Min() {
        Student s = lobj.get(0);

        int iMin = s.Marks;

        for (Student sref : lobj) {
            if (iMin > sref.Marks) {
                iMin = sref.Marks;
            }
        }

        System.out.println("Minimum marks are : " + iMin);
    }

}

class CDBMS {
    public static void main(String Arg[]) {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();
    }
}