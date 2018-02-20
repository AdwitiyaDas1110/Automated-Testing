
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestProject1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       
       /*You need to create automation testing of http://automationpractice.com using selenium.*/
        System.setProperty("webdriver.chrome.driver","C:\\Users\\adwitiya\\Downloads\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver wdChrome = new ChromeDriver();
        wdChrome.get("http://automationpractice.com");
        
        /*Add one product from Popular category to cart.*/
        wdChrome.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")).click();
        Thread.sleep(2000);
        wdChrome.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
        Thread.sleep(2000);
        
        //Click more button from one of the Popular category product and go to details page.
        wdChrome.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[2]")).click();
        
//Change quantity to 3 from that page and add that product to cart.
        for(int i = 1 ; i <= 2 ; i++){
            wdChrome.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")).click();
        }
        wdChrome.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        
        //Go to T-shirt category and sort them using “Price: Lowest First” filter.
        wdChrome.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
        wdChrome.findElement(By.xpath("//*[@id=\"selectProductSort\"]/option[2]")).click();
       
        //Add first product to cart after sorting.
        wdChrome.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
        Thread.sleep(2000);
        
        //Go to Cart page
        wdChrome.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
        
        //Change quantity of last product to 5.
        int value = Integer.parseInt(wdChrome.findElement(By.xpath("//*[@id=\"product_1_1_0_0\"]/td[5]/input[2]")).getAttribute("value"));
        if(value<5){
          int press = 5 - value;
          for(int i = 1; i <= press; i++){
             wdChrome.findElement(By.xpath("//*[@id=\"cart_quantity_up_1_1_0_0\"]/span/i")).click();
          }
      }
        
      //Click proceed to checkout button
      wdChrome.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
    }
    
}