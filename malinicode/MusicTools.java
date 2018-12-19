public class MusicTools {
/**
*<h1> Prints the contents of an array!</h1>
* This method prints the contents of an array on a single line with commas and a space between each element
*@author    Malini Kundamal
*@param     array, an array of double values
*/
public static void printArray(double array[]){

    for (int i=0; i < array.length-1; i++)
    {
      System.out.print(array[i] + ",");
    }
    if(array.length>0)
    {
      System.out.print(array[array.length-1]);
    } 

  System.out.println();
}

/**
*<h1> Converts an array of doubles to an array of strings!</h1>
* This method returns the contents of an array of strings
*@author    Malini Kundamal
*@param     array, an array of double values
*@return    arrayOfStrings, an array of Strings
*/
public static String arrayToString(double array[]) {

  String arrayOfStrings = "";
  for (int i=0; i<array.length-1;i++)
  {
    arrayOfStrings = arrayOfStrings + Double.toString(array[i]) + ", ";
  }
  if (array.length>0)
  {
    arrayOfStrings = arrayOfStrings+Double.toString(array[array.length-1]);
  }

  return arrayOfStrings;
}

/**
*<h1> Checks if two arrays have equal values!</h1>
* This method compares two arrays and checks if they are equal in size and content
*@author    Malini Kundamal
*@param     array1, an array of double values
*@param     array2, an array of double values
*@return    boolean, it returns true if both arrays are equal
*/
public static boolean arraysAreEqual(double array1[], double array2[]) {

  if (array1.length != array2.length)
  {
    return false;
  }
  for (int i=0; i<array1.length;i++) {
    if (array1[i]!=array2[i])
    {
      return false;
    }
  }
  return true;

}

/**
*<h1> Reverses the values of an array!</h1>
* This method returns an array of double values in reversed order
*@author    Malini Kundamal
*@param     array, an array of double values
*@return    reversedArray, an array of double values in reversed order
*/
public static double[] reverseArray(double array[]) {

  double[] reversedArray = new double[array.length];
    for (int i = 0; i < reversedArray.length; i++)
    {
    reversedArray[i]=array[array.length-i-1];
  }
  return reversedArray;

}

/**
*<h1> Gets the max of an array!</h1>
* This method returns the max value of an array of doubles
*@author    Malini Kundamal
*@param     array, an array of double values
*@return    maxValue, the max double value of an array
*/
public static double findArrayMax(double array[]){

  double maxValue = Double.NEGATIVE_INFINITY;
    for (int i = 0; i<array.length;i++)
    {
      if (array[i] > maxValue)
      {
        maxValue = array[i];
      }
    }
    return maxValue;

}

/**
*<h1> Gets the min of an array!</h1>
* This method returns the min value of an arrray.
*@author    Malini Kundamal
*@param     array, an array of double values
*@return    minValue, the min double value of an array
*/
public static double findArrayMin(double array[]){

  double minValue = Double.POSITIVE_INFINITY;
  for (int i = 0; i<array.length;i++)
  {
    if (array[i] < minValue)
    {
      minValue = array[i];
    }
  }
  return minValue;

}

/**
*<h1> Scales the values of an array!</h1>
* This method scales each double value in the array by a scaler.
*@author    Malini Kundamal
*@param     array, an array of double values
*@param     scaler, double value
*@return    scaledArray, a scaled array of double values
*/
public static double[] scaleArray(double array[],double scaler) {

  double[] scaledArray = new double[array.length];
  for (int i = 0; i < scaledArray.length; i++)
  {
    scaledArray[i]=array[i]*scaler;
  }
  return scaledArray;

}

/**
*<h1> Performs weighted addition of two arrays!</h1>
* This method performs the weighted addition of two arrays.
*@author    Malini Kundamal
*@param     array1, an array of double values
*@param     array2, an array of double values
*@param     firstWeight, the weighted double value for array1
*@param     secondWeight, the weighted double value for array2
*@return    finalArray, the resulting weigted and added array
*/
public static double[] weightedAddArray(double[] array1, double[] array2, double firstWeight, double secondWeight){

    if (firstWeight + secondWeight != 1)
    {
      double[] empty_a = {};
      return empty_a;
    }

    double[] weightArray1 = new double[array1.length];
    double[] weightArray2 = new double[array2.length];

    if(weightArray1.length > weightArray2.length)
    {
      for (int i = 0; i < weightArray2.length; i++)
      {
        weightArray1[i]= weightArray2[i];
      }
      for(int m = weightArray2.length; m < weightArray2.length; m++)
      {
        weightArray2[m] = 0;
      }
      double[] finalArray = new double[array1.length];
      for(int n = 0; n < finalArray.length; n++)
      {
        finalArray[n] = (array1[n] * firstWeight) + (weightArray2[n]*secondWeight);
      }
      return finalArray;

    }

    else if (array2.length > array1.length)
    {
      for (int i = 0; i < weightArray1.length; i++)
      {
        weightArray1[i]= array1[i];
      }
      for(int m = weightArray1.length; m < weightArray1.length; m++)
      {
        weightArray1[m] = 0;
      }
      double[] finalArray = new double[array2.length];
      for(int n = 0; n < finalArray.length; n++)
      {
        finalArray[n] = (finalArray[n] * firstWeight) + (array2[n]*secondWeight);
      }
      return finalArray;

    }

    else {

      double[] finalArray = new double[array1.length];
      for (int i=0; i<finalArray.length; i++)
      {
        finalArray[i] = (array1[i] * firstWeight) + (array2[i]*secondWeight);
      }
      return finalArray;
    }

  }

/**
*<h1> Copies an array of doubles!</h1>
* This method returns a new array of doubles that is a smaller version of the original array
*@author    Malini Kundamal
*@param     array, an array of double values
*@param     firstParam, inclusive value
*@param     secondParam, exclusive value
*@return    finalArray, an array of doubles that is the smaller version of the original array
*/
public static double[] copyArray(double[] array, int firstParam, int secondParam){

  if ((firstParam > secondParam) || (firstParam == secondParam))
  {
    double[] empty_a = {};
    return empty_a;
  }
  if (firstParam<0)
  {
    double[] empty_a = {};
    return empty_a;
  }

  double[] finalArray = new double[secondParam - firstParam];
  for (int i=0;i<finalArray.length;i++)
  {
    finalArray[i]=array[firstParam+i];
  }
  return finalArray;

}

/**
* <h1> Cuts an array od doubles!</h1>
* This method returns an array of doubles without the portion from the first paramter to the second paramater.
*@author Malini Kundamal
*@param   array, an array of double values
*@param   firstParam, inclusive value
*@param   secondParam, exclusive value
*@return  finalArray, an array of double values with the portion from the original array removed
*/
public static double[] cutArray(double[] array, int firstParam, int secondParam){

  if (firstParam > secondParam || firstParam < 0)
  {
    double[] empty_a = {};
    return empty_a;
  }
  int length = secondParam-firstParam;
  double[] finalArray = new double[array.length-length];
  for (int i=0; i<firstParam; i++)
  {
    finalArray[i]=array[i];
  }
  for (int i=0; i<array.length-secondParam;i++)
  {
    finalArray[i+firstParam]=array[secondParam+i];
  }

  return finalArray;

}

/**
*<h1> Concatenates an array of doubles!</h1>
* This method adds the second array onto the end of the first array
*@author    Malini Kundamal
*@param     array1, an array of double values
*@param     array2, an array of double values
*@return    finalArray, the final concatenated array of double values
*/
public static double[] concatArray(double array1[], double array2[]){

  double[] finalArray = new double[array1.length + array2.length];
  for (int i=0; i < array1.length; i++)
  {
    finalArray[i]=array1[i];
  }
  for (int m = array1.length; m<finalArray.length; m++)
  {
    finalArray[m] = array2[m-array1.length];
  }
  return finalArray;

}

/**
*<h1> Splices an array of doubles!</h1>
* This method returns an array of doubles that is the first array inserted into a second array at a specified place
*@author    Malini Kundamal
*@param     array1, an array of double values
*@param     array2, an array of double values
*@param     arrayPlace, where the second array should be placed
*@return    finalArray, an array of double values with array2 placed into array1 at arrayPlace
*
*/

public static double[] spliceArray(double array1[], double array2[], int arrayPlace) {

  if (arrayPlace >= array1.length)
  {
    double[] empty_a = {};
    return empty_a;
  }
  double[] finalArray = new double[array1.length + array2.length];
  for (int i = 0; i < arrayPlace; i++)
  {
    finalArray[i] = array1[i];
  }
  for (int i = 0; i < array2.length; i++)
  {
    finalArray[i+arrayPlace] = array2[i];
  }
  for (int i = arrayPlace; i<array1.length; i++)
  {
    finalArray[i+array2.length] = array1[i];
  }

  return finalArray;

}

public static void main(String args[]){
  double[] a = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  double[] b = {1.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  double[] c = {0.0,3.0, 5.0,7.0};
  double[] lengthOne = {3.0};
  double[] empty_a = {};
  double[] expectedArray, actualArray;
  double expectedDouble, actualDouble;
  String label = "", error_msg = "", expectedString="", actualString="";

/////////////////////////////////////arrayToString////////////////////////////////////////
  System.out.println("Testing arrayToString...");

  expectedString = "0.0, 0.5, 1.0, 1.5, 2.0, 2.5";
  actualString = MusicTools.arrayToString(a);
  assertStringsAreEqual("basic array", expectedString, actualString, "The basic arrayToString did not convert the array of doubles to an array of strings.");

  expectedString = "";
  actualString = MusicTools.arrayToString(empty_a);
  assertStringsAreEqual("empty array", expectedString, actualString, "The empty array is not working.");

  System.out.println("All tests for toString pass!");
  System.out.println("");

//////////////////////////////////////arraysAreEqual///////////////////////////////////////
  System.out.println("Testing arraysAreEqual...");

  System.out.println("Checking two arrays that are different...\nExpected:"+false+" Actual:"+MusicTools.arraysAreEqual(a, b));
  assert MusicTools.arraysAreEqual(a, b) == false: "Although array a and array b are not equal, arraysAreEqual returns that they are equal.";
  System.out.println("++++++++");

  System.out.println("Checking two arrays that are same...\nExpected:"+true+" Actual:"+MusicTools.arraysAreEqual(a, a));
  assert MusicTools.arraysAreEqual(a, a) == true: "Array a and array b are equal, but arraysAreEqual returns that they are not equal.";
  System.out.println("++++++++");

  System.out.println("Checking first array that's empty...\nExpected:"+false+" Actual:"+MusicTools.arraysAreEqual(empty_a, a));
  assert MusicTools.arraysAreEqual(empty_a, a) == false: "Array should not be empty.";
  System.out.println("++++++++");

  System.out.println("Checking second array that's empty...\nExpected:"+false+" Actual:" + MusicTools.arraysAreEqual(a,empty_a));
  assert MusicTools.arraysAreEqual(a, empty_a) == false: "Array should not be empty.";
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
  assertArraysAreEqual("basic reversal",expectedArray, actualArray, "The array has not been reversed!!");

  expectedArray = lengthOne;
  actualArray =  MusicTools.reverseArray(expectedArray);
  assertArraysAreEqual("reversing an array with a length of one",expectedArray, actualArray, "Array with a length of one is not reversed");

  expectedArray = empty_a;
  actualArray =  MusicTools.reverseArray(expectedArray);
  assertArraysAreEqual("empty array",expectedArray, actualArray, "Empty array has not beenreversed");

  System.out.println("All tests for reverseArray pass!");
  System.out.println("");

//////////////////////////////////////findArrayMax///////////////////////////////////////
  System.out.println("Testing findArrayMax...");
  expectedDouble = 2.5;
  actualDouble = MusicTools.findArrayMax(a);
  assertDoublesAreEqual("basic max", expectedDouble, actualDouble, "Basic max is not the max");

  actualDouble = 3.0;//MusicTools.findArrayMax(lengthOne)
  assertDoublesAreEqual("array of a length of one", expectedDouble, actualDouble, "Max of an array of one length is not the max.");

  expectedDouble = Double.NEGATIVE_INFINITY;
  actualDouble =  MusicTools.findArrayMax(empty_a);
  assertDoublesAreEqual("empty array", expectedDouble, actualDouble, "Max of empty is not the max.");

  System.out.println("All tests for findArrayMax pass!");
  System.out.println("");

//////////////////////////////////////findArrayMin///////////////////////////////////////
  System.out.println("Testing findArrayMin...");
  expectedDouble = 0.0;
  actualDouble = MusicTools.findArrayMin(a);
  assertDoublesAreEqual("basic min", expectedDouble, actualDouble, "Basic min is not the min.");

  expectedDouble=3.0;
  actualDouble=MusicTools.findArrayMin(lengthOne);
  assertDoublesAreEqual("an array with a length of one", expectedDouble, actualDouble, "Min of an array with a length of one is not the min.");

  expectedDouble = Double.POSITIVE_INFINITY;
  actualDouble =  MusicTools.findArrayMin(empty_a);
  assertDoublesAreEqual("empty array", expectedDouble, actualDouble, "Min of empty is not the min.");

  System.out.println("All tests for findArrayMin pass!");
  System.out.println("");

//////////////////////////////////////scaleArray///////////////////////////////////////
  System.out.println("Testing scaleArray...");
  expectedArray = new double[]{0.0, 1.5, 3.0, 4.5, 6.0, 7.5};
  actualArray = MusicTools.scaleArray(a,3);
  assertArraysAreEqual("basic scale by factor of 3", expectedArray, actualArray, "Basic scale is incorrect");

  expectedArray = empty_a;
  actualArray =  MusicTools.scaleArray(empty_a,3);
  assertArraysAreEqual("scale of empty array", expectedArray, actualArray, "scale of empty is incorrect");

  System.out.println("All tests for scaleArray pass!");
  System.out.println("");

//////////////////////////////////////weightedAddArray///////////////////////////////////////
  System.out.println("Testing weightedAddArray...");
  expectedArray = new double[]{0.8, 0.5, 1, 1.5, 2, 2.5};
  actualArray = MusicTools.weightedAddArray(a,b,.2,.8);
  assertArraysAreEqual("weights are .2 and .8", expectedArray, actualArray, "basic weighted add is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.weightedAddArray(a,b,.2,.8);
  assertArraysAreEqual("weights don't add to 1", expectedArray, actualArray, "weights do not add to 1");

  expectedArray = new double[]{0.0,1.2,1.8,2.6,1.6,2};
  actualArray = MusicTools.weightedAddArray(c,a,.2,.8);
  assertArraysAreEqual("arrays have different lengths and weights are .2 and .8", expectedArray, actualArray, "weighted add is incorrect");

  System.out.println("All tests for weightedAddArray pass!");
  System.out.println("");

//////////////////////////////////////copyArray///////////////////////////////////////
  System.out.println("Testing copyArray...");
  expectedArray = new double[]{0.5,1.0};
  actualArray = MusicTools.copyArray(a,1,3);
  assertArraysAreEqual("basic copy array", expectedArray, actualArray, "basic copy is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.copyArray(a,3,3);
  assertArraysAreEqual("same index start/end", expectedArray, actualArray, "cannot have the same number for first and second paramter");

  expectedArray = empty_a;
  actualArray = MusicTools.copyArray(a,3,0);
  assertArraysAreEqual("larger start than end", expectedArray, actualArray, "cannot have a larger first paramater than second");

  expectedArray = empty_a;
  actualArray = MusicTools.copyArray(a,-1,2);
  assertArraysAreEqual("negative index (start)", expectedArray, actualArray, "cannot have a negative start");

  System.out.println("All tests for copyArray pass!");
  System.out.println("");

//////////////////////////////////////cutArray///////////////////////////////////////
  System.out.println("Testing cutArray...");
  expectedArray = new double[]{0.0,1.5,2.0,2.5};
  actualArray = MusicTools.cutArray(a,1,3);
  assertArraysAreEqual("basic cut array", expectedArray, actualArray, "basic cut is incorrect");

  expectedArray = new double[]{0.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  actualArray = MusicTools.cutArray(a,3,3);
  assertArraysAreEqual("same number for first paramter and second paramter", expectedArray, actualArray, "cannot have same number for first parameter and second parameter");

  expectedArray = empty_a;
  actualArray = MusicTools.cutArray(a,3,0);
  assertArraysAreEqual("larger firstparam than secondparam", expectedArray, actualArray, "cannot have larger firstparam than secondparam");

  expectedArray = empty_a;
  actualArray = MusicTools.cutArray(a,-1,1);
  assertArraysAreEqual("negative firstparam", expectedArray, actualArray, "cannot have negative firstparam");

  System.out.println("All tests for cutArray pass!");
  System.out.println("");

//////////////////////////////////////concatArray///////////////////////////////////////
  System.out.println("Testing concatArray...");
  expectedArray = new double[]{1.0, 0.5,1.0,1.5,2.0,2.5,0.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  actualArray = MusicTools.concatArray(a,b);
  assertArraysAreEqual("basic concat array", expectedArray, actualArray, "basic concat is incorrect");

  expectedArray = new double[]{1.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  actualArray = MusicTools.concatArray(empty_a,a);
  assertArraysAreEqual("empty array", expectedArray, actualArray, "cannot have empty array");

  expectedArray = new double[]{1.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  actualArray = MusicTools.concatArray(a,empty_a);
  assertArraysAreEqual("empty array ", expectedArray, actualArray, "cannot have empty array");

  expectedArray = empty_a;
  actualArray = MusicTools.concatArray(empty_a,empty_a);
  assertArraysAreEqual(" empty arrays", expectedArray, actualArray, "cannot have empty arrays");


  System.out.println("All tests for concatArray pass!");
  System.out.println("");


//////////////////////////////////////spliceArray///////////////////////////////////////
  System.out.println("Testing spliceArray...");
  expectedArray = new double[]{1.0, 0.0, 0.5, 1.0, 1.5, 2.0, 2.5,0.5, 1.0, 1.5, 2.0, 2.5};
  actualArray = MusicTools.spliceArray(a,b,1);
  assertArraysAreEqual("basic splice array", expectedArray, actualArray, "basic splice is incorrect");

  expectedArray = empty_a;
  actualArray = MusicTools.spliceArray(a,b,14);
  assertArraysAreEqual("paramter is larger than total length of arrays", expectedArray, actualArray, "Paramter cannot be larger than the arrays combined length.");

  System.out.println("All tests for spliceArray pass!");
  System.out.println("");

}

public static void assertStringsAreEqual(String testLabel, String expected, String actual, String errorMessage){
  System.out.println("Checking "+testLabel+"...\nExpected:"+expected+" Actual:"+actual);
  assert expected.equals(actual): errorMessage;
  System.out.println("++++++++");
}

public static void assertDoublesAreEqual(String testLabel, Double expected, Double actual, String errorMessage) {
  System.out.println("Checking "+testLabel+"...\nExpected:"+expected+" Actual:"+actual);
  assert (expected.equals(actual)): errorMessage;
  System.out.println("++++++++");
}

public static void assertArraysAreEqual(String testLabel, double[] expected, double[] actual, String errorMessage){
  System.out.println("Checking "+testLabel+ "...\nExpected:" + MusicTools.arrayToString(expected)+ " Actual:"+ MusicTools.arrayToString(actual));
  assert MusicTools.arraysAreEqual(expected,actual): errorMessage;
  System.out.println("++++++++");
}
}
