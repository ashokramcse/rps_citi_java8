package com.citi.banking.utility;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.citi.banking.data.ProductInfo;
import com.citi.banking.models.CreditCard;
import com.citi.banking.models.Product;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
public class BuilinFunctionalInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //built in functional interface
		//one input and one output
		//Temporary invocations
		Function<Integer,Boolean> fn=data->	data%2==0;
		Function<Integer,String> message=data->	{
	         if(data>10)
	        	 return "High";
	         else
	        	 return "low";
			
			};
		System.out.println(fn.apply(67));
		System.out.println(message.apply(67));
		
		//two inputs and one output
		BiFunction<Product,Product,Boolean> compare=(x,y)->{
			
			if(x.getPurchaseCost()>y.getPurchaseCost())
				return true;
			else
				return false;
		};
		
		System.out.println(compare.apply(new Product(438756834,"Sony Laptop",78000,
				new Date(115,5,15)),new Product(438756834,"Sony Laptop",56000,
						new Date(115,5,15))));
		
		//Consumer
		
		Consumer<List<Product>> traverse=(list)->{
			
			//System.out.println(list);
			list.forEach((obj)->{
				System.out.println(obj.getName());
			});
		};
		
		traverse.accept(ProductInfo.getProducts());
		
		//BiConsumer	
		
		BiConsumer<Product,Integer> productTraverse=(key,value)->
		{
			System.out.println(key.getName()+"->"+value);
		};	
		
	    ProductInfo.getHTList().forEach(productTraverse);
		
		//Predicates
	    
	    Predicate<Product> testString=(obj)->obj.getName().startsWith("B");
	    
	    System.out.println(testString.test(new Product(438756834,"Sony Laptop",
	    		56000,	new Date(115,5,15))));
	    
	    //BiPredicate
	    BiPredicate<Product,Integer> testBudget=
	    		(obj,amount)->obj.getPurchaseCost()<amount && 
	    		obj.getName().startsWith("S"); 
	    		
	    		
	   System.out.println( testBudget.test(new Product(438756834,"Sony Laptop",
	    		    		56000,	new Date(115,5,15)),80000));		
	    
	    
	  //Supplier
	   
	  Supplier<CreditCard> supplierObj=CreditCard::new;	  
	  Function<CreditCard,Date> testLength=(obj)->{
	     if(obj.getCardNo().length()==12)
            return obj.getExpiryDate();
	     else
	    	 return null;
            		
	  };	   
	  Function<Date,Boolean> testExpDate=(expDate)->
	  {
		//System.out.println(expDate);  
		if(expDate.getYear()>new Date().getYear())
			return true;
		else
			return false;
	  };  
      testLength.andThen(testExpDate).apply(supplierObj.get().getData());	  
			  
      Optional<String> optional = Optional.of("City Corp");
        //nullability test 
      System.out.println("present"+optional.isPresent());           // true
      System.out.println("Get"+optional.get());                 // "banner"
		optional.orElse("Null"+"fallback");    // "banner"
         //nullability test   
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));  
	   
		 Optional<String> nullData = Optional.ofNullable(null);
		System.out.println( nullData.isPresent());   
		nullData.ifPresent((s) -> System.out.println(s.charAt(0)));  
		
	}

}
