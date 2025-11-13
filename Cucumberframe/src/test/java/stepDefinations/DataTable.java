package stepDefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTable {

@Then("I have product information 2 columns asmap:")
public void i_have_product_information(io.cucumber.datatable.DataTable dataTable) {
	Map<String, String> productdata = dataTable.asMap(String.class, String.class);
   System.out.println(productdata);
   
   System.out.println("product name:" + productdata.get("name"));
   System.out.println("Product price:" + productdata.get("price"));
   System.out.println("product company" +productdata.get("Brand"));
}
@When("I have product information in single column aslist:")
public void i_have_product_information_aslist(io.cucumber.datatable.DataTable dataTable) {
   List<String> products = dataTable.asList(String.class);
   System.out.println(products);
   for(String product: products) {
	   System.out.println(product);
   }
}
@And("You get a list of lists, where each inner list is one row :")
public void you_get_a_list_of_lists_where_each_inner_list_is_one_row(io.cucumber.datatable.DataTable dataTable) {
   List< List<String>> totaldetails = dataTable.asLists(String.class);
   System.out.println(totaldetails);
   for(int i =0;i < totaldetails.size() ;i++) {
	   
	   System.out.println("list one by one" + totaldetails.get(i));
	   
   }
  
}
@Then("For multi-row key–value pairs \\(when the first row contains headers):")
public void for_multi_row_key_value_pairs_when_the_first_row_contains_headers(io.cucumber.datatable.DataTable dataTable) {
   List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
   System.out.println(products);
   for(int i=0; i<products.size();i++) {
	   System.out.println("products" +products.get(i));
	   
   }
   for (Map<String, String> product : products) {
       System.out.println("Product Name: " + product.get("name"));
       System.out.println("Price: " + product.get("price"));
       System.out.println("Brand: " + product.get("brand"));
       System.out.println("-----");
   }
   
   
}







}
