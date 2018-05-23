package com.citi.banking.utility;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;

import com.rps.facades.PredicateInterface;

public class LamdaPredicates {
public static void main(String[] args) {
	//Function<T,R>
	Function<Integer, Integer> function = v -> v * 10;

	System.out.println(function.apply(10));
	//BiFunction
	BiFunction<Integer,Integer,Integer> bifunction = (x,y)-> {return (x > y ? x : y);};
	System.out.println(bifunction.apply(6, 7));
	//BiConsumer does not return values
	 Map<Integer,String> map = new HashMap<>();
     map.put(1, "A");
     map.put(2, "B");
     map.put(3, "C");
     BiConsumer<Integer,String> biConsumer = (key,value) -> 
						System.out.println("Key:"+ key+" Value:"+ value);
     map.forEach(biConsumer);
     
     
     //BiPredicate
     BiPredicate<Integer, String> condition = (i,s)-> i>20 && s.startsWith("R");
     System.out.println(condition.test(10,"Ram"));
     System.out.println(condition.test(30,"Shyam"));
     System.out.println(condition.test(30,"Ram"));
     //Binary Operator
     BinaryOperator<Integer> operator = (a, b) -> a + b;
		Function<Integer, Integer> fn = n -> n * 2;

		// Using andThen()
		System.out.println("And Then");
		System.out.println(operator.andThen(fn).apply(1, 6));
		
	//Binary Operator with Comparator
		Comparator<Integer> comparator = (a, b) -> (a.compareTo(b));

		// Using maxBy()
		BinaryOperator<Integer> opMax = BinaryOperator.maxBy(comparator);
		System.out.println("Max: " + opMax.apply(5, 6));
		System.out.println("Max: " + opMax.apply(9, 6));

		// Using minBy()
		BinaryOperator<Integer> opMin = BinaryOperator.minBy(comparator);
		System.out.println("Min: " + opMin.apply(5, 6));
		System.out.println("Min: " + opMin.apply(9, 6));
		
		//Boolean Supplier
		 int x = 0, y= 1;
		BooleanSupplier bs = () -> x > y;
	    System.out.println(bs.getAsBoolean());
	    String s1 = "ABC";
	    String s2 = "ABC";
	    BooleanSupplier stringEquals = () -> s1.equals(s2);
	    System.out.println(stringEquals.getAsBoolean()); //Outputs true
     
	//Double Predicate
	    DoublePredicate predicate1 = (d) -> d >= 0;
		DoublePredicate predicate2 = (d) -> d == 5.4;

		// Using and()
		System.out.println(predicate1.and(predicate2).test(5.4));
		System.out.println(predicate1.and(predicate2).test(5.5));

		// Using or()
		System.out.println(predicate1.or(predicate2).test(5.5));

		// Using negate()
		System.out.println(predicate1.negate().test(-5.5));

//Double Function
		DoubleFunction<String> dfunction=(d)->{
			return "Input value is "+d;
		};
		
		System.out.println(dfunction.apply(4.5));
		System.out.println(dfunction.apply(15.5));
   //Double to Int function
		
		 DoubleToIntFunction ob = f -> new Double(f*4.8).intValue();
	        System.out.println(ob.applyAsInt(43.7));
   //Double Bi Function
	        ToDoubleBiFunction<Integer,Integer> tob = (f1,f2) -> f1+f2;
	        System.out.println(tob.applyAsDouble(102,305));
	        
	    
	//Predicates
	Predicate<String> isALongWord = t -> t.length() > 10;
	
	String s = "successfully";
	System.out.println(isALongWord.test(s)); 
	
	// Using Predicate interface  
    Predicate<Integer> predicate =  PredicateInterface::checkAge;  
    // Calling Predicate method  
    System.out.println(predicate.test(25));  
}
}
