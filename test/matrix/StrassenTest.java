/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sohaib
 */
public class StrassenTest {
    
    public StrassenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void multiplyMatTest() {
        System.out.println("multiplyMat");
        int[][] A = {{1,1,1},{1,1,1},{1,1,1}};
        int[][] B = {{1,1,1},{1,1,1},{1,1,1}};
        Strassen instance = new Strassen();
        int[][] expResult = {{3,3,3},{3,3,3},{3,3,3}};
        int[][] result = instance.multiplyMat(A, B);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case failed for iterative method");
    }
    
    /**
     * Test of multiply method, of class Strassen.
     */
    @Test
    public void testMultiply1() {
        System.out.println("multiply");
        int[][] A = {{1,1,1},{1,1,1},{1,1,1}};
        int[][] B = {{1,1,1},{1,1,1},{1,1,1}};
        Strassen instance = new Strassen();
        int[][] expResult ={{3,3,3},{3,3,3},{3,3,3}}; ;
        int[][] result = instance.multiply(A, B);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case failed for 2x3.");
    }
    
    @Test
    public void testMultiply2() {
        System.out.println("multiply");
        int[][] A=new int[50][50] ;
        int[][] B =new int[50][50];
        for(int i=0;i<50;i++){
            for (int j=0;j<50;j++){
            A[i][j]=1;
            B[i][j]=2;
            }
        }
        Strassen instance = new Strassen();
        int[][] expResult = instance.multiplyMat(A, B);
        int[][] result = instance.multiply(A, B);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case failed for 50x50.");
    }

     @Test
    public void testMultiply3() {
        System.out.println("multiply");
        int[][] A=new int[100][3] ;
        int[][] B =new int[100][3];
        for(int i=0;i<100;i++){
            for (int j=0;j<3;j++){
            A[i][j]=1;
            B[i][j]=2;
            }
        }
        Strassen instance = new Strassen();
        int[][] expResult = instance.multiplyMat(A, B);
        int[][] result = instance.multiply(A, B);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case failed for 100x3.");
    }
    
     @Test
    public void testMultiply4() {
        System.out.println("multiply");
        int[][] A=new int[1000][1000] ;
        int[][] B =new int[1000][1000];
        for(int i=0;i<1000;i++){
            for (int j=0;j<1000;j++){
            A[i][j]=1;
            B[i][j]=2;
            }
        }
        Strassen instance = new Strassen();
        int[][] expResult = instance.multiplyMat(A, B);
        int[][] result = instance.multiply(A, B);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case failed for 1000x1000.");
    }

    

    
    
    
    /**
     * Test of padding method, of class Strassen.
     */
    @Test
    public void testPadding() {
        System.out.println("padding");
        int[][] a = {{1,1,1},{1,1,1},{1,1,1}};
        int[][] b = {{1,1,1},{1,1,1},{1,1,1}};
        Strassen instance = new Strassen();
        int expResult = 4;
        int result = instance.padding(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Wrong padding.");
    }

}
