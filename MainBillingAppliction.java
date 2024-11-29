
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainBillingAppliction {

	public static void main(String[] args) {
	
	    ArrayList<Product> al=new ArrayList<>();
	  //for our infomartion fisrtly add products details manually
	   Product prod1=new Product(123,"soap",345,20);
	   Product prod2=new Product(1234,"oil",600,80);
	   Product prod3=new Product(1236,"Rice",700,90);
	   Product prod4=new Product(1250,"sugar",900,40);
	   
	   al.add(prod1);
	   al.add(prod2);
	   al.add(prod3);
	   al.add(prod4);
	   
			Scanner sc=new Scanner(System.in);
			System.out.println("\t\t"+"Billing Appliction");
			boolean switchFlag=true;
			while(switchFlag)
			{
			System.out.println("\n\t\t"+"1.Admin Login");
			System.out.println("\n\t\t"+"2.User Login");
			System.out.println("\n\t\t"+"3.Exit");
			
			System.out.println("-------------------------------------------------------------------------------------------------------------------");
			int choice=0;

			try {
					choice=sc.nextInt();
		}catch (InputMismatchException e) 
        {
            System.out.println("Enter digits only.");
            sc.nextLine();  // Clear buffer after invalid input
        
        }
		
		   switch(choice)
		   {
		   case 1://admin case start
			   boolean adminFlag=true;
			   while(adminFlag)
			   {
			   System.out.println("\t\t"+"1.Add Product");
			   System.out.println("\n\t\t"+"2.Delete Product");
			   System.out.println("\n\t\t"+"3.Update Product");
			   System.out.println("\n\t\t"+"4.View All Product");
			   System.out.println("\n\t\t"+"5.Product Billing");
			   System.out.println("\n\t\t"+"6.Exit");
			  
				 
			   System.out.println("-------------------------------------------------------------------------------------------------------------------");
		
				   int productchoice;
				   productchoice=sc.nextInt();
				   switch( productchoice)
				   {
				   case 1://Add Product case start
					   System.out.println("\t\t"+"Add new Product:");
					  
					   System.out.println("Enter Product Id:");
					   
					   
					   
						   int prodId=0;
						   try {
						   prodId=sc.nextInt();
						   }
						   catch (InputMismatchException e) 
					        {
					            System.out.println("Enter digits only.");
					            sc.nextLine();  // Clear buffer after invalid input
					        
					        }
						    
						   
					   sc.nextLine();
					   
					   boolean idExists = false;
					    for (Product p : al) {
					        if (p.getProdId() == prodId) {
					            idExists = true;
					            break;
					        }
					    }
					    
					    if (idExists) {
					        System.out.println("Product ID already exists. Try again.");
					        break;
					    }
					  
					    
					   System.out.println("Enter Product Name:");
					   
					   String productname="";
					   try {
					   productname=sc.nextLine();
					   }catch (InputMismatchException e) 
				        {
				            System.out.println("Enter String only.");
				            sc.nextLine();  // Clear buffer after invalid input
				        
				        }
					  
					   System.out.println("Enter Available Stock");
					   int stock=0;
					   try {
					   stock=sc.nextInt();
					   }catch (InputMismatchException e) 
				        {
				            System.out.println("Enter digits only.");
				            sc.nextLine();  // Clear buffer after invalid input
				        
				        }
					   
					   if (stock < 0) {
					        System.out.println("Stock cannot be negative. Try again.");
					        break;
					    }
					   
					   System.out.println("Enter Product Price:");
					   double price=0;
					   try {
						   price=sc.nextInt();
					   }catch (InputMismatchException e) 
				        {
				            System.out.println("Enter digits only.");
				            sc.nextLine();  // Clear buffer after invalid input
				        
				        }
				
					   Product p1=new Product(prodId,productname,stock,price);
					   al.add(p1);
					   System.out.println("Product Added Succefully");					  
					   break;// add product case end
					   
				   case 2://Delete  Product case Start
					 System.out.println("Delete Product:");
					 
					 if(al.isEmpty())
					 {
						 System.out.println("No products available to delete.");
						 break;
					 }
					   System.out.println("Enter Product Id for Delete product:");
					   int deleteProId=sc.nextInt();
					   
					   boolean found=false;
					   Iterator<Product> iterator=al.iterator();
					   while(iterator.hasNext())
					   {
						   Product p=iterator.next();
						   if(p.getProdId()==deleteProId)
						   {
							   iterator.remove();
							   found=true;
							   System.out.println("Product deleted successfully!");
							   break;
						   }
					   }
					   if (!found) {
					        System.out.println("Product with ID " + deleteProId + " not found.");
					    }
					   break;// delete case end
					   
					   
				   case 3://update case start
					   System.out.println("\t\t"+"Update Products:");
					   
					   if(al.isEmpty())
					   {
						   System.out.println("No products available to update.");
					        break;   
					   }
					   
					   System.out.print("Enter Product ID to update: ");
					    int updateId = sc.nextInt();
					    sc.nextLine();
					    
					     found =false;
					     for(Product p:al)
					     {
					    	 if(p.getProdId()==updateId)
					    	 {
					    		 found=true;
					    		 System.out.println("Product found: ");
					    		 System.out.printf("ID: %d, Name: %s, Stock: %d%nPrice: %.2f%n", p.getProdId(), p.getName(), p.getStock(), p.getPrice());
					             boolean upadteFlag=true;
					             while(upadteFlag)
					             {
					            	 System.out.println("\nWhat do want to Update?");
					            	 System.out.println("1. Product Name");
					                 System.out.println("2. Product ID");
					                 System.out.println("3. Product Stock");
					                 System.out.println("4. Product Price");
					                 System.out.println("5. Exiting Update Menu.");
					                 
					                 System.out.print("Enter your choice: ");
					                 int updatechoice=sc.nextInt();
					                 sc.nextLine(); 
					                 switch(updatechoice)
					                 {
					                 
					                 case 1: // Update Product Name
					                	    System.out.print("Enter new Product Name: ");
					                	    String newName = sc.nextLine();
					                	    p.setName(newName);
					                	    System.out.println("Product Name updated successfully!");
					                	    break;

					                	case 2: // Update Product ID
					                	    System.out.print("Enter new Product ID: ");
					                	    int newId = sc.nextInt();
					                	    p.setProdId(newId);
					                	    System.out.println("Product ID updated successfully!");
					                	    break;

					                	case 3: // Update Stock
					                	    System.out.print("Enter new Stock: ");
					                	    int newStock = sc.nextInt();
					                	    if (newStock < 0) {
					                	        System.out.println("Stock cannot be negative!");
					                	    } else {
					                	        p.setStock(newStock);
					                	        System.out.println("Product Stock updated successfully!");
					                	    }
					                	    break;

					                	case 4: // Update Product Price
					                	    System.out.print("Enter new Product Price: ");
					                	    double  newPrice = sc.nextInt();
					                	    if (newPrice < 0) {
					                	        System.out.println("Price cannot be negative!");
					                	    } else {
					                	        p.setPrice(newPrice);
					                	        System.out.println("Product Price updated successfully!");
					                	    }
					                	    break;

					                	case 5: // Exit Update Menu
					                	    upadteFlag = false;
					                	    System.out.println("Exiting Update Menu.");
					                	    break;

					                	default:
					                	    System.out.println("Invalid choice. Please try again.");
					                	    break;
					                }
					                 
					                 }
					             break;
					                
					            	}
					    	 }
					    if(!found)
					    {
					    	 System.out.println("Product with ID " + updateId + " not found.");
					    }
					   break;//upadate case end 
					   
				   case 4://Show All products
					   
					   System.out.println("\t\tAll Products:");
					   System.out.printf("%-15s %-30s %-15s %-15s%n", "Product ID", "Product Name", "Product Stock", "Product Price");//%-15s, %-30s, %-15s  ensure aligned columns with adequate width.
					   if(al.isEmpty())
					   {
						   System.out.println("No Products Available");
					   }
					   else
					   {
						   for(Product p:al)
						   {
							   System.out.printf("%-15d %-30s %-15d %-15.2f%n", p.getProdId(), p.getName(), p.getStock(), p.getPrice());//%-15s, %-30s, %-15n  ensure aligned columns with adequate width.
						   }
					   }
					   break;
				   case 5://Billing Menu
					   System.out.println("\t\tProduct Billing");

					   if (al.isEmpty()) {
					       System.out.println("No products available for billing.");
					       break;
					   }

					   // Customer Details
					   System.out.print("Enter Customer Name: ");
					   sc.nextLine(); // Consume any leftover newline
					   String customerName = sc.nextLine();

					   System.out.print("Enter Customer Address: ");
					   String customerAdd = sc.nextLine();

					   Customer cs = new Customer(customerName, customerAdd);

					   double totalAmount = 0;
					   ArrayList<Product> cart = new ArrayList<>(); // To store products added to the cart

					   while (true) {
					       // Display available products
					       System.out.println("\nAvailable Products: ");
					       System.out.printf("%-15s %-30s %-15s %-15s%n", "Product ID", "Product Name", "Stock", "Price");
					       for (Product p : al) {
					           System.out.printf("%-15d %-30s %-15d %-15.2f%n", p.getProdId(), p.getName(), p.getStock(), p.getPrice());
					       }

					       // Ask user for product ID
					       System.out.print("Enter Product ID to add to cart (or 0 to finish): ");
					       int prodid = sc.nextInt();

					       if (prodid == 0) {
					           break; // Exit the loop if the user enters 0
					       }

					       boolean productFound = false;
					       for (Product p : al) {
					           if (p.getProdId() == prodid) {
					               productFound = true;

					               // Ask user for quantity
					               System.out.print("Enter quantity: ");
					               int qty = sc.nextInt();

					               if (qty > p.getStock()) {
					                   System.out.println("Insufficient stock. Try again.");
					                   break;
					               }

					               // Add to cart
					               p.setStock(p.getStock() - qty); // Reduce stock
					               Product cartProduct = new Product(p.getProdId(), p.getName(), qty, p.getPrice());
					               cart.add(cartProduct);

					               totalAmount += p.getPrice() * qty; // Update total amount
					               System.out.println("Added to cart: " + p.getName() + " x " + qty);
					               break;
					           }
					       }

					       if (!productFound) {
					           System.out.println("Product ID not found. Try again.");
					       }
					   }

					   // Check if cart is empty
					   if (cart.isEmpty()) {
					       System.out.println("No products were added to the cart. Billing canceled.");
					       break;
					   }

					   // Print receipt
					   
					   LocalDate todaydate = LocalDate.now();
					   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

					   System.out.println("\n\t\tReceipt");
					   System.out.println("Date: " + todaydate.format(formatter)); // Display today's date
					   System.out.println("Customer: " + cs.getName());
					   System.out.println("Address: " + cs.getAddress());
					   
					   System.out.println("--------------------------------------------------------");
					   System.out.printf("%-15s %-30s %-10s %-15s%n", "Product ID", "Product Name", "Quantity", "Price");

					   for (Product p : cart) {
					       System.out.printf("%-15d %-30s %-10d %-15.2f%n", p.getProdId(), p.getName(), p.getStock(), p.getPrice() * p.getStock());
					   }

					   System.out.println("--------------------------------------------------------");
					   System.out.printf("Total Amount: %.2f%n", totalAmount);
					   System.out.println("Thank You! Visit Again....");
					   break;
					   
				case 6:
					  
					   adminFlag=false;
					   System.out.println("Exiting Admin Menu.");
					   break;
					   
				   }
				   
				   }
				   break;
				   
		
			   
			   
		   case 2:// user case start
			   System.out.println("\t\tProduct Billing");

			   if (al.isEmpty()) {
			       System.out.println("No products available for billing.");
			       break;
			   }

			   // Customer Details
			   System.out.print("Enter Customer Name: ");
			   sc.nextLine(); // Consume any leftover newline
			   String customerName = sc.nextLine();

			   System.out.print("Enter Customer Address: ");
			   String customerAdd = sc.nextLine();

			   Customer cs = new Customer(customerName, customerAdd);

			   double totalAmount = 0;
			   ArrayList<Product> cart = new ArrayList<>(); // To store products added to the cart

			   while (true) {
			       // Display available products
			       System.out.println("\nAvailable Products: ");
			       System.out.printf("%-15s %-30s %-15s %-15s%n", "Product ID", "Product Name", "Stock", "Price");
			       for (Product p : al) {
			           System.out.printf("%-15d %-30s %-15d %-15.2f%n", p.getProdId(), p.getName(), p.getStock(), p.getPrice());
			       }

			       // Ask user for product ID
			       System.out.print("Enter Product ID to add to cart (or 0 to finish): ");
			       int prodid = sc.nextInt();

			       if (prodid == 0) {
			           break; // Exit the loop if the user enters 0
			       }

			       boolean productFound = false;
			       for (Product p : al) {
			           if (p.getProdId() == prodid) {
			               productFound = true;

			               // Ask user for quantity
			               System.out.print("Enter quantity: ");
			               int qty = sc.nextInt();

			               if (qty > p.getStock()) {
			                   System.out.println("Insufficient stock. Try again.");
			                   break;
			               }

			               // Add to cart
			               p.setStock(p.getStock() - qty); // Reduce stock
			               Product cartProduct = new Product(p.getProdId(), p.getName(), qty, p.getPrice());
			               cart.add(cartProduct);

			               totalAmount += p.getPrice() * qty; // Update total amount
			               System.out.println("Added to cart: " + p.getName() + " x " + qty);
			               break;
			           }
			       }

			       if (!productFound) {
			           System.out.println("Product ID not found. Try again.");
			       }
			   }

			   // Check if cart is empty
			   if (cart.isEmpty()) {
			       System.out.println("No products were added to the cart. Billing canceled.");
			       break;
			   }

			   // Print receipt
			   
			   LocalDate todaydate = LocalDate.now();
			   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			   System.out.println("\n\t\t Bill Receipt");
			   System.out.println("Date: " + todaydate.format(formatter)); // Display today's date
			   System.out.println("Customer: " + cs.getName());
			   System.out.println("Address: " + cs.getAddress());
			   
			   System.out.println("--------------------------------------------------------");
			   System.out.printf("%-15s %-30s %-10s %-15s%n", "Product ID", "Product Name", "Quantity", "Price");

			   for (Product p : cart) {
			       System.out.printf("%-15d %-30s %-10d %-15.2f%n", p.getProdId(), p.getName(), p.getStock(), p.getPrice() * p.getStock());
			   }

			   System.out.println("--------------------------------------------------------");
			   System.out.printf("Total Amount: %.2f%n", totalAmount);
			   System.out.println("Thank You! Visit Again....");
			   
			   
			   
			   break;//end
			  
				
		   case 3:
			   switchFlag=false;
			   break;
			 
				   
			   default:
				   System.out.println("Wrong choice");
				   
				  
		   }
				   
		   
		   }
				
			
		

	}

}
