/*
 *All images courtesy https://www.butterfliesandmoths.org.
 */
package ButterflySearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Random;
import org.jsoup.HttpStatusException;

/**
 *
 * @author shomonamukherjee
 */
public class ButterflySearchModel {

    public String doButterflySearch(String species, String region, String stage, String picSize) throws IOException {
        //url to get from
        String url = "https://www.butterfliesandmoths.org/gallery?species="
                + species
                + "&family=All&subfamily=All&type=All&view=All&stage="
                + stage
                + "&region="
                + region;
        
        Document doc = null;

        try {
            //Connect and get dom with jsoup
           doc = Jsoup.connect(url).validateTLSCertificates(false).timeout(50000).get();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        } catch (HttpStatusException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Elements images = null;
        String srcSelect = null;
        //If it is mobile select the thumbnail image on the page and attr as src
        if (picSize.equals("mobile")) {
            images = doc.select("img");
            srcSelect = "src";

        }//Else for desktop select the anchor tag and the href for the main picture
        else {
            images = doc.select("a");
            srcSelect = "href";
        }

        //To store the image srcs
        List<String> imageLinks = new ArrayList<>();
        int countLink = 0;

        //Iterate over image tags find the relevant images and add it to a list
        //Limit the no of images you add to the list to 40
        for (Element image : images) {
            String src = image.attr(srcSelect);
            if (!src.contains("https://www.butterfliesandmoths.org/")) {
                continue;
            }

            countLink++;
            imageLinks.add(src);
            if (countLink == 40) {
                break;
            }
        }
        
        //If there is nothing  in the arraylist return null
        int size = imageLinks.size();
        if(size == 0) return null;
        
        //Randomly select one image
        Random rand = new Random();
        return imageLinks.get(rand.nextInt(size));

    }

}
