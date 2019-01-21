/**
Run with Assertions enabled:
 > java -ea MusicToolsTester
*/
public class MusicToolsTester{

public static void main(String args[]){
  double[] a = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  double[] b = {1.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  double[] empty_a = {};
  String label = "", error_msg = "", expectedString="", actualString="";
  double[] expectedArray, actualArray;


  /////////////////////////////////////arrayToString////////////////////////////////////////
  System.out.println("Testing arrayToString...");

  expectedString = "0.0, 0.5, 1.0, 1.5, 2.0, 2.5";
  actualString = MusicTools.arrayToString(a);
  assertStringsAreEqual("basic array", expectedString, actualString, "basic arrayToString doesn't work");

  expectedString = "";
  actualString = MusicTools.arrayToString(empty_a);
  assertStringsAreEqual("emtpy array", expectedString, actualString, "empty array doesn't work");

  System.out.println("All tests for toString pass!");
  System.out.println("");

  //////////////////////////////////////arraysAreEqual///////////////////////////////////////
  System.out.println("Testing arraysAreEqual...");

  System.out.println("Checking two arrays that are different...Expected:"+false+" Actual:"+MusicTools.arraysAreEqual(a, b));
  assert MusicTools.arraysAreEqual(a, b) == false: "The a and b arrays are not equal, but arraysAreEqual says they are equal";

  System.out.println("Checking two arrays that are same...Expected:"+true+" Actual:"+MusicTools.arraysAreEqual(a, a));
  assert MusicTools.arraysAreEqual(a, a) == true: "The a and b arrays are equal, but arraysAreEqual says they are not equal";

  System.out.println("Checking first array that's empty...");
  System.out.println("Checking first array that's empty...Expected:"+true+" Actual:"+MusicTools.arraysAreEqual(a, a));
  assert MusicTools.arraysAreEqual(empty_a, a) == false: "First empty array should not be empty to an array with values.";

  System.out.println("Checking second array that's empty...");
  assert MusicTools.arraysAreEqual(a, empty_a) == false: "Second empty array should not be empty to an array with values.";

  System.out.println("Checking two arrays that are empty...");
  assert MusicTools.arraysAreEqual(empty_a, empty_a) == true: "Two empty arrays should be equal.";

  System.out.println("All tests for arraysAreEqual pass!");
  System.out.println("");


  //////////////////////////////////////reverseArray///////////////////////////////////////
  System.out.println("Testing reverseArray...");
  expectedArray = new double[]{2.5, 2.0, 1.5, 1.0, 0.5, 0.0};
  actualArray = MusicTools.reverseArray(a);
  assertArraysAreEqual("basic reversal",expectedArray, actualArray, "The array is not reversed");

  expectedArray = new double[]{2.5};
  actualArray =  MusicTools.reverseArray(expectedArray);
  assertArraysAreEqual("reversal of a one spot array",expectedArray, actualArray, "One spot array is not reversed");

  expectedArray = empty_a;
  actualArray =  MusicTools.reverseArray(expectedArray);
  assertArraysAreEqual("empty array",expectedArray, actualArray, "Empty array is not reversed");

  System.out.println("All tests for reverseArray pass!");
  System.out.println("");
}//main

  public static void assertStringsAreEqual(String testLabel, String expected, String actual, String errorMessage){
    System.out.println("Checking "+testLabel+"...\nExpected:"+expected+" Actual:"+actual);
    assert expected.equals(actual): errorMessage;
    System.out.println("++++++++");
  }//assertStringsAreEqual helper method

  public static void assertArraysAreEqual(String testLabel, double[] expected, double[] actual, String errorMessage){
    System.out.println("Checking "+testLabel+"...");
    System.out.println("Expected:"+MusicTools.arrayToString(expected)+" Actual:"+MusicTools.arrayToString(actual));
    assert MusicTools.arraysAreEqual(expected,actual): errorMessage;
    System.out.println("++++++++");
  }//assertArraysAreEqual helper method

}//MusicTools library
