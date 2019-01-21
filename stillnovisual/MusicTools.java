public class MusicTools {
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Print the contents of an array!</h1>
* This method prints the contant of an array on a single line, with commas and a space between each element
*
*@author    Leah Teichholtz
*@param     array, an array of double values to be printed
*
*/
public static void printArray(double array[]){

    for (int i=0; i < array.length-1; i++){
      System.out.print(array[i] + ",");
    }
    if(array.length>0){
      System.out.print(array[array.length-1]);
    }

  System.out.println();
}//printArray
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Convert an array to a string!</h1>
* This method returns a single-line string version of the array, with commas between each element
*
*@author    Leah Teichholtz
*@param     array, an array of double values to be converted to a string
*@return    arrayString, the string version of array
*
*/
public static String arrayToString(double array[]) {
  String arrayString = "";
  for (int i=0; i<array.length-1;i++){
    arrayString = arrayString + Double.toString(array[i]) + ", ";
  }
  if (array.length>0){
    arrayString = arrayString+Double.toString(array[array.length-1]);
  }
  return arrayString;
}//arrayToString
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Check if two arrays are equal!</h1>
* This method compares two arrays for equality, including size and content
*
*@author    Leah Teichholtz
*@param     array1, an array of double values
*@param     array2, an array of double values
*@return    boolean, returns true when the arrays are equivalent
*
*/
public static boolean arraysAreEqual(double array1[], double array2[]) {
  if (array1.length != array2.length) return false;
  for (int i=0; i<array1.length;i++) {
    if (array1[i]!=array2[i]) return false;
  }
  return true;
} //arraysAreEqual
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Reverse the components of an array!</h1>
* This method returns a new array with the contents of the original array in reversed order
*
*@author    Leah Teichholtz
*@param     array, an array of double values to be reversed
*@return    reversedArray, an array of reversed double values
*
*/
public static double[] reverseArray(double array[]) {
  double[] reversedArray = new double[array.length];
    for (int i = 0; i < array.length; i++) {
    reversedArray[i]=array[array.length-i-1];
  }
  return reversedArray;
}//reversedArray
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Find the maximum number of an array!</h1>
* This method returns the maximum value in an array
*
*@author    Leah Teichholtz
*@param     array, an array of double values
*@return    max, a double; the largest number in array
*
*/
public static double findArrayMax(double array[]){
  double max = Double.NEGATIVE_INFINITY;
    for (int i = 0; i<array.length;i++){
      if (array[i] > max){
        max = array[i];
      }
    }
    return max;
} //findArrayMax
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Find the minimum number of an array!</h1>
* This method returns the minimum number in an arrray.
*
*@author    Leah Teichholtz
*@param     array, an array of double values
*@return    min, a double; the smallest number in array
*
*/
public static double findArrayMin(double array[]){
  double min = Double.POSITIVE_INFINITY;
  for (int i = 0; i<array.length;i++){
    if (array[i] < min){
      min = array[i];
    }
  }
  return min;
} //findArrayMin
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Scale an array!</h1>
* This method scales every value in the array by a common multiplier.
*
*@author    Leah Teichholtz
*@param     array, an array of double values to be scaled
*@param     multiplier, double of the common multiplier
*@return    b, the scaled array of double values
*
*/
public static double[] scaleArray(double array[],double multiplier) {
  double[]b = new double[array.length];
  for (int i = 0; i < array.length; i++) {
    b[i]=array[i]*multiplier;
  }
  return b;
}//scaleArray
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Weighted addition of two arrays!</h1>
* This method performs the weighted addition of two arrays, assuming that missing tail values are 0.
*
*@author    Leah Teichholtz
*@param     array1, an array of double values to be weighed
*@param     array2, an array of double values to be weighed
*@param     weight1, a double, the weight of array1
*@param     weight2, a double, the weight of array2
*@return    addedArray, the array of double values after weighted addition
*
*/
public static double[] weightedAddArray(double[] array1, double[] array2, double weight1, double weight2){
    if (weight1 + weight2 != 1) {
      double[] empty_a = {};
      return empty_a;
    }

    double[] newArray2 = new double[array1.length];//initializing expanded arrays
    double[] newArray1 = new double[array2.length];

    if(array1.length > array2.length){ //array1 bigger
      for (int i = 0; i < array2.length; i++)
        newArray2[i]= array2[i];
      for(int f = array2.length; f < newArray2.length; f++)
        newArray2[f] = 0;
      double[] addedArray = new double[array1.length];
      for(int i = 0; i < addedArray.length; i++)
        addedArray[i] = (array1[i] * weight1) + (newArray2[i]*weight2);
      return addedArray;
    }

    else if (array2.length > array1.length) { //array2 bigger
      for (int i = 0; i < array1.length; i++) {
        newArray1[i]= array1[i];
      }
      for(int f = array1.length; f < newArray1.length; f++) {
        newArray1[f] = 0;
      }
      double[] addedArray = new double[array2.length];
      for(int i = 0; i < addedArray.length; i++) {
        addedArray[i] = (newArray1[i] * weight1) + (array2[i]*weight2);
      }
      return addedArray;
    }

    else { // same lengths
      double[] addedArray = new double[array1.length];
      for (int i=0; i<addedArray.length; i++) {
        addedArray[i] = (array1[i] * weight1) + (array2[i]*weight2);
      }
      return addedArray;
    }
  }//weightedAddArray
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Copy an array!</h1>
* This method returns a new array that is a smaller portion of the original array according to start/end parameters
*
*@author    Leah Teichholtz
*@param     array, an array of double values to be copied
*@param     start, int where method begins copying (inclusive)
*@param     end, int where method ends copying (exclusive)
*@return    copiedArray, an array that is a portion of the original after copying
*
*/
public static double[] copyArray(double[] array, int start, int end){
  if ((start > end) || (start == end)) {
    double[] empty_a = {};
    return empty_a;
  }
  if (start<0) {
    double[] empty_a = {};
    return empty_a;
  }

  double[] copiedArray = new double[end - start];
  for (int i=0;i<copiedArray.length;i++){
    copiedArray[i]=array[start+i];
  }
  return copiedArray;
}//copyArray
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
* <h1> Cut an array!</h1>
* This method returns a new array that removes a portion of the original array according to start/end parameters
*
*@param   array, an array of double values to be cut
*@param   start, an int where method starts cutting (inclusive)
*@param   end, an int where method stops cutting (exclusive)
*@return  newArray, an array of double values with a portion removed
*
*/
public static double[] cutArray(double[] array, int start, int end){
  if (start > end || start < 0) {
    double[] empty_a = {};
    return empty_a;
  }

  double[] newArray = new double[array.length-(end-start)];
  for (int i=0; i<start; i++) {
    newArray[i]=array[i];
  }
  for (int i=0; i<array.length-end;i++) {
    newArray[i+start]=array[end+i];
  }

  return newArray;

}//cutArray
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Concatenate an array!</h1>
* This method concatenates two arrays by adding the second array to the end of the first array
*
*@author    Leah Teichholtz
*@param     array1, an array of double values
*@param     array2, an array of double values to be added to the end of array1
*@return    newArray, the concatenated array of double values
*
*/
public static double[] concatArray(double array1[], double array2[]){
  double[]newArray = new double[array1.length + array2.length];
  for (int i=0; i < array1.length; i++) {
    newArray[i]=array1[i];
  }
  for (int j = array1.length; j<newArray.length; j++){
    newArray[j] = array2[j-array1.length];
  }
  return newArray;
} //concatArray

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
/**
*<h1> Splice an array!</h1>
* This method returns a new array that is one array inserted into a second array at the specified index
*
*@author    Leah Teichholtz
*@param     array1, an array of double values to receive the inserted array
*@param     array2, the array of double values to be inserted
*@param     index, the int where the second array should be inserted
*@return    splicedArray, an array of double values that is array2 inserted into array1 at index
*
*/

public static double[] spliceArray(double array1[], double array2[], int index) {
  if (index >= array1.length) {
    double[] empty_a = {};
    return empty_a;
  }

  double[] splicedArray = new double[array1.length + array2.length];
  for (int i = 0; i < index; i++) {
    splicedArray[i] = array1[i];
  }
  for (int i = 0; i < array2.length; i++) {
    splicedArray[i+index] = array2[i];
  }
  for (int i = index; i<array1.length; i++) {
    splicedArray[i+array2.length] = array1[i];
  }

  return splicedArray;
} //spliceArray




//testing done in main
public static void main(String args[]){
  double[] a = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  double[] b = {1.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  double[] c = {1.0, 2.0, 3.0};
  double[] d = {5.0, 6.0, 0.0};

  double[] onespot = {2.5};
  double[] empty_a = {};
  String label = "", error_msg = "", expectedString="", actualString="";
  double[] expectedArray, actualArray;
  double expectedDouble, actualDouble;


/////////////////////////////////////arrayToString////////////////////////////////////////
  System.out.println("Testing arrayToString...");

  expectedString = "0.0, 0.5, 1.0, 1.5, 2.0, 2.5";
  actualString = MusicTools.arrayToString(a);
  assertStringsAreEqual("basic array", expectedString, actualString, "basic arrayToString doesn't work");

  expectedString = "";
  actualString = MusicTools.arrayToString(empty_a);
  assertStringsAreEqual("empty array", expectedString, actualString, "empty array doesn't work");

  System.out.println("All tests for toString pass!");
  System.out.println("");

//////////////////////////////////////arraysAreEqual///////////////////////////////////////
  System.out.println("Testing arraysAreEqual...");

  System.out.println("Checking two arrays that are different...\nExpected:"+false+" Actual:"+MusicTools.arraysAreEqual(a, b));
  assert MusicTools.arraysAreEqual(a, b) == false: "The a and b arrays are not equal, but arraysAreEqual says they are equal";
  System.out.println("++++++++");

  System.out.println("Checking two arrays that are same...\nExpected:"+true+" Actual:"+MusicTools.arraysAreEqual(a, a));
  assert MusicTools.arraysAreEqual(a, a) == true: "The a and b arrays are equal, but arraysAreEqual says they are not equal";
  System.out.println("++++++++");

  System.out.println("Checking first array that's empty...\nExpected:"+false+" Actual:"+MusicTools.arraysAreEqual(empty_a, a));
  assert MusicTools.arraysAreEqual(empty_a, a) == false: "First empty array should not be empty to an array with values.";
  System.out.println("++++++++");

  System.out.println("Checking second array that's empty...\nExpected:"+false+" Actual:" + MusicTools.arraysAreEqual(a,empty_a));
  assert MusicTools.arraysAreEqual(a, empty_a) == false: "Second empty array should not be empty to an array with values.";
  System.out.println("++++++++");

  System.out.println("Checking two arrays that are empty...\nExpected:"+ true+" Actual:"+MusicTools.arraysAreEqual(empty_a,empty_a));
  assert MusicTools.arraysAreEqual(empty_a, empty_a) == true: "Two empty arrays should be equal.";
  System.out.println("++++++++");

  System.out.println("All tests for arraysAreEqual pass!");
  System.out.println("");


//////////////////////////////////////reverseArray///////////////////////////////////////
  System.out.println("Testing reverseArray...");
  expectedArray = new double[]{2.5, 2.0, 1.5, 1.0, 0.5, 0.0};
  actualArray = MusicTools.reverseArray(a);
  assertArraysAreEqual("basic reversal",expectedArray, actualArray, "The array is not reversed");

  expectedArray = onespot;
  actualArray =  MusicTools.reverseArray(expectedArray);
  assertArraysAreEqual("reversal of a one spot array",expectedArray, actualArray, "One spot array is not reversed");

  expectedArray = empty_a;
  actualArray =  MusicTools.reverseArray(expectedArray);
  assertArraysAreEqual("empty array",expectedArray, actualArray, "Empty array is not reversed");

  System.out.println("All tests for reverseArray pass!");
  System.out.println("");

//////////////////////////////////////findArrayMax///////////////////////////////////////
  System.out.println("Testing findArrayMax...");
  expectedDouble = 2.5;
  actualDouble = MusicTools.findArrayMax(a);
  assertDoublesAreEqual("basic max", expectedDouble, actualDouble, "Basic max is incorrect");

  actualDouble = MusicTools.findArrayMax(onespot);
  assertDoublesAreEqual("one spot array", expectedDouble, actualDouble, "Max of a one spot array is incorrect");

  expectedDouble = Double.NEGATIVE_INFINITY;
  actualDouble =  MusicTools.findArrayMax(empty_a);
  assertDoublesAreEqual("empty array", expectedDouble, actualDouble, "Max of empty is incorrect");

  System.out.println("All tests for findArrayMax pass!");
  System.out.println("");

//////////////////////////////////////findArrayMin///////////////////////////////////////
  System.out.println("Testing findArrayMin...");
  expectedDouble = 0.0;
  actualDouble = MusicTools.findArrayMin(a);
  assertDoublesAreEqual("basic min", expectedDouble, actualDouble, "Basic min is incorrect");

  expectedDouble=2.5;
  actualDouble=MusicTools.findArrayMin(onespot);
  assertDoublesAreEqual("one spot array", expectedDouble, actualDouble, "Min of a one spot array is incorrect");

  expectedDouble = Double.POSITIVE_INFINITY;
  actualDouble =  MusicTools.findArrayMin(empty_a);
  assertDoublesAreEqual("empty array", expectedDouble, actualDouble, "Min of empty is incorrect");

  System.out.println("All tests for findArrayMin pass!");
  System.out.println("");

//////////////////////////////////////scaleArray///////////////////////////////////////
  System.out.println("Testing scaleArray...");
  expectedArray = new double[]{0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
  actualArray = MusicTools.scaleArray(a,2);
  assertArraysAreEqual("basic scale by 2", expectedArray, actualArray, "Basic scale is incorrect");

  expectedArray = empty_a;
  actualArray =  MusicTools.scaleArray(empty_a,2);
  assertArraysAreEqual("scale empty array", expectedArray, actualArray, "scale of empty is incorrect");

  System.out.println("All tests for scaleArray pass!");
  System.out.println("");

//////////////////////////////////////weightedAddArray///////////////////////////////////////
  System.out.println("Testing weightedAddArray...");
  expectedArray = new double[]{2.0,3.0,2.25};
  actualArray = MusicTools.weightedAddArray(c,d,.75,.25);
  assertArraysAreEqual("same length, weights .75/.25", expectedArray, actualArray, "basic weighted add is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.weightedAddArray(c,d,.75,.75);
  assertArraysAreEqual("weights don't add to 1", expectedArray, actualArray, "return when weights don't add to 1 incorrect");

  expectedArray = new double[]{0.25,0.875,1.5,1.125,1.5,1.875};
  actualArray = MusicTools.weightedAddArray(a,c,.75,.25);
  assertArraysAreEqual("different length (1-6, 2-3), weights .75/.25", expectedArray, actualArray, "diff length weighted add is incorrect");

  expectedArray = new double[]{0.75,1.625,2.5,0.375,0.5,0.625};
  actualArray = MusicTools.weightedAddArray(c,a,.75,.25);
  assertArraysAreEqual("different length (1-3, 2-6), weights .75/.25", expectedArray, actualArray, "diff length weighted add is incorrect");

  System.out.println("All tests for weightedAddArray pass!");
  System.out.println("");

//////////////////////////////////////copyArray///////////////////////////////////////
  System.out.println("Testing copyArray...");
  expectedArray = new double[]{1.0,1.5};
  actualArray = MusicTools.copyArray(a,2,4);
  assertArraysAreEqual("basic copy array", expectedArray, actualArray, "basic copy is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.copyArray(a,2,2);
  assertArraysAreEqual("same index start/end", expectedArray, actualArray, "same index for start/end is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.copyArray(a,2,0);
  assertArraysAreEqual("larger start than end", expectedArray, actualArray, "larger start than end is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.copyArray(a,-2,3);
  assertArraysAreEqual("negative index (start)", expectedArray, actualArray, "negative start incorrect");

  System.out.println("All tests for copyArray pass!");
  System.out.println("");

//////////////////////////////////////cutArray///////////////////////////////////////
  System.out.println("Testing cutArray...");
  expectedArray = new double[]{0.0,0.5,2.0,2.5};
  actualArray = MusicTools.cutArray(a,2,4);
  assertArraysAreEqual("basic cut array", expectedArray, actualArray, "basic cut is incorrect");

  expectedArray = new double[]{0.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  actualArray = MusicTools.cutArray(a,2,2);
  assertArraysAreEqual("same index start/end", expectedArray, actualArray, "same index for start/end is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.cutArray(a,4,2);
  assertArraysAreEqual("larger start than end", expectedArray, actualArray, "larger start than end is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.cutArray(a,-2,2);
  assertArraysAreEqual("negative index (start)", expectedArray, actualArray, "negative start incorrect");

  System.out.println("All tests for cutArray pass!");
  System.out.println("");

//////////////////////////////////////concatArray///////////////////////////////////////
  System.out.println("Testing concatArray...");
  expectedArray = new double[]{0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 5.0, 6.0, 0.0};
  actualArray = MusicTools.concatArray(a,d);
  assertArraysAreEqual("basic concat array", expectedArray, actualArray, "basic concat is incorrect");

  expectedArray = new double[]{5.0,6.0,0.0};
  actualArray = MusicTools.concatArray(empty_a,d);
  assertArraysAreEqual("empty array 1st", expectedArray, actualArray, "empty array 1st is incorrect");

  expectedArray = new double[]{5.0,6.0,0.0};
  actualArray = MusicTools.concatArray(d,empty_a);
  assertArraysAreEqual("empty array 2nd", expectedArray, actualArray, "empty array 2nd is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.concatArray(empty_a,empty_a);
  assertArraysAreEqual("2 empty arrays", expectedArray, actualArray, "2 empty arrays is incorrect");


  System.out.println("All tests for concatArray pass!");
  System.out.println("");


//////////////////////////////////////spliceArray///////////////////////////////////////
  System.out.println("Testing spliceArray...");
  expectedArray = new double[]{0.0,0.5, 5.0, 6.0, 0.0, 1.0, 1.5, 2.0, 2.5};
  actualArray = MusicTools.spliceArray(a,d,2);
  assertArraysAreEqual("basic splice array", expectedArray, actualArray, "basic splice is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.spliceArray(a,d,8);
  assertArraysAreEqual("index too big", expectedArray, actualArray, "index too big incorrect");

  System.out.println("All tests for spliceArray pass!");
  System.out.println("");

}//main


public static void assertStringsAreEqual(String testLabel, String expected, String actual, String errorMessage){
  System.out.println("Checking "+testLabel+"...\nExpected:"+expected+" Actual:"+actual);
  assert expected.equals(actual): errorMessage;
  System.out.println("++++++++");
}//assertStringsAreEqual helper method

public static void assertDoublesAreEqual(String testLabel, Double expected, Double actual, String errorMessage) {
  System.out.println("Checking "+testLabel+"...\nExpected:"+expected+" Actual:"+actual);
  assert (expected.equals(actual)): errorMessage;
  System.out.println("++++++++");
}//assertDoublesAreEqual helper method

public static void assertArraysAreEqual(String testLabel, double[] expected, double[] actual, String errorMessage){
  System.out.println("Checking "+testLabel+ "...\nExpected:" + MusicTools.arrayToString(expected)+ " Actual:"+ MusicTools.arrayToString(actual));
  assert MusicTools.arraysAreEqual(expected,actual): errorMessage;
  System.out.println("++++++++");
}//assertArraysAreEqual helper method

}
