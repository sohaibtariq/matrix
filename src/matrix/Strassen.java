/*
THIS CODE HAS BEEN WRITTEN WITH HELP FROM THE C++ CODE PROVIDED ON LMS AND FROM THE 
IMPLEMENTATION OF STRASSENS ALGORITHM LOCATED ON:http://www.sanfoundry.com/java-program-strassen-algorithm/

THE PADDING FUNCTIONALITY AND ALL UNIT TESTS ARE COMPLETELY ORIGINAL
 */
package matrix;

/**
 *
 * @author Sohaib
 */
/**
 ** Java Program to Implement Strassen Algorithm
 **/
 
import java.util.Scanner;
 
/** Class Strassen **/
public class Strassen
{
    /** Function to multiply matrices **/
    public int[][] multiply(int[][] A, int[][] B)
    {        
        int n = A.length;
        
        /** base case **/
        int zeros=padding(A,B);      
        int[][] R;
        
        if (n <= 2){
            R=multiplyMat(A,B);
            return R;
        
        }
        else
        {
            R = new int[zeros][zeros];
            
             int[][] arr1=new int[zeros][zeros];
             int[][] arr2=new int[zeros][zeros];
                         
             
             for (int i=0; i<A.length;i++){
                 for(int j=0; j<A[0].length;j++){
                 arr1[i][j]=A[i][j];
                 }
             }
             
             
             for (int i=0; i<B.length;i++){
                 for(int j=0; j<B[0].length;j++){
                 arr2[i][j]=B[i][j];
                 }
             }
             
             
             
/*           System.arraycopy(A, 0, arr1, 0, (A.length ));
             System.arraycopy(B, 0, arr2, 0, (B.length ));
  */           
             A=arr1;
             B=arr2;
             
             
             n=zeros;
                        
             
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            /** Dividing matrix A into 4 halves **/
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);
            /** Dividing matrix B into 4 halves **/
          split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2,n/2);
               
            /** 
              M1 = (A11 + A22)(B11 + B22)
              M2 = (A21 + A22) B11
              M3 = A11 (B12 - B22)
              M4 = A22 (B21 - B11)
              M5 = (A11 + A12) B22
              M6 = (A21 - A11) (B11 + B12)
              M7 = (A12 - A22) (B21 + B22)
             
            **/
            
          /*  for (int i = 0; i < n/2; i++) {
            A11[i] = new int[n];
            A12[i] = new int[n];
            A21[i] = new int[n];
            A22[i] = new int[n];
            B11[i] = new int[n];
            B12[i] = new int[n];
            B21[i] = new int[n];
            B22[i] = new int[n];
            for (int j = 0; j < n/2; j++) {

                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + n/2];
                A21[i][j] = A[i + n/2][j];
                A22[i][j] = A[i + n/2][j + n/2];

                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + n/2];
                B21[i][j] = B[i + n/2][j];
                B22[i][j] = B[i + n/2][j + n/2];

            }
        }
        */    
            int [][] M1 = multiply(add(A11, A22), add(B11, B22));
            int [][] M2 = multiply(add(A21, A22), B11);
            int [][] M3 = multiply(A11, sub(B12, B22));
            int [][] M4 = multiply(A22, sub(B21, B11));
            int [][] M5 = multiply(add(A11, A12), B22);
            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));
 
            /**
              C11 = M1 + M4 - M5 + M7
              C12 = M3 + M5
              C21 = M2 + M4
              C22 = M1 - M2 + M3 + M6
            **/
            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
            /** join 4 halves into one result matrix **/
            join(C11, R, 0 , 0);
            join(C12, R, 0 , n/2);
            join(C21, R, n/2, 0);
            join(C22, R, n/2, n/2);
            
        }
        /** return result **/    
        return R;
    }
    
    public int padding(int[][] a, int[][]b  ){
    
    int aRows=a.length;
    int aCols=a[0].length;
    int bRows=b.length;
    int bCols=b[0].length;
    
    int max=Math.max(aRows,aCols);
    int max2=Math.max(bRows,bCols);
    int max3=Math.max(max,max2);
    
    int y=(int)Math.pow(2,(Math.floor(Math.log(max3) / Math.log(2)) + 1));
    
    return y;

    }
    
    int[][] multiplyMat(int[][] firstarray, int[][]secondarray) {
     
  int [][] result = new int[firstarray.length][secondarray[0].length];

/* Loop through each and get product, then sum up and store the value */
for (int i = 0; i < firstarray.length; i++) { 
    for (int j = 0; j < secondarray[0].length; j++) { 
        for (int k = 0; k < firstarray[0].length; k++) { 
            result[i][j] += firstarray[i][k] * secondarray[k][j];
        }
    }
  }
return result;
}
      
    
    
   

    
    /** Funtion to sub two matrices **/
    public int[][] sub(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
    /** Funtion to add two matrices **/
    public int[][] add(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
    /** Funtion to split parent matrix into child matrices **/
    public void split(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length ; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length ; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
    /** Funtion to join child matrices intp parent matrix **/
    public void join(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }    
    /** Main function **/

    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Strassen Multiplication Algorithm Test\n");
        /** Make an object of Strassen class **/
        Strassen s = new Strassen();
        
 
        System.out.println("Enter order n :");
        int N = scan.nextInt();
        /** Accept two 2d matrices **/
        
       // int xyz=s.padding(N);
       //System.out.println(xyz);
        
        System.out.println("Enter N order matrix 1\n");
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = scan.nextInt();
 
        System.out.println("Enter N order matrix 2\n");
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                B[i][j] = scan.nextInt();
 
        int[][] C = s.multiply(A, B);
 
        System.out.println("\nProduct of matrices A and  B : ");
        int size=A.length;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
                System.out.print(C[i][j] +" ");
            System.out.println();
        }
 
    }
}