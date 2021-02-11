package com.lml.util;

public class test {
    public static void main(String[] args) {
        String urll = "https://shop.royalcanin.fr/dogs/,"+
                "https://shop.royalcanin.fr/dog-age/babydog/,"+
                "https://shop.royalcanin.fr/dog-age/puppy/,"+
                "https://shop.royalcanin.fr/dog-age/adult/,"+
                "https://shop.royalcanin.fr/dog-age/senior/,"+
                "https://shop.royalcanin.fr/dog-size/x-small/,"+
                "https://shop.royalcanin.fr/dog-size/mini/,"+
                "https://shop.royalcanin.fr/dog-size/medium/,"+
                "https://shop.royalcanin.fr/dog-size/maxi/,"+
                "https://shop.royalcanin.fr/dog-size/giant/,"+
                "https://shop.royalcanin.fr/dog-range/breed-health-nutrition/,"+
                "https://shop.royalcanin.fr/dog-range/veterinary-care-nutrition/,"+
                "https://shop.royalcanin.fr/dog-range/size-health-nutrition/,"+
                "https://shop.royalcanin.fr/dog-range/dry-products/,"+
                "https://shop.royalcanin.fr/dog-range/wet-products/,"+
                "https://shop.royalcanin.fr/cats/,"+
                "https://shop.royalcanin.fr/cat-age/babycat/,"+
                "https://shop.royalcanin.fr/cat-age/adult/,"+
                "https://shop.royalcanin.fr/cat-age/mature/,"+
                "https://shop.royalcanin.fr/cat-age/senior/,"+
                "https://shop.royalcanin.fr/cat-range/feline-breed-nutrition/,"+
                "https://shop.royalcanin.fr/cat-range/feline-care-nutrition/,"+
                "https://shop.royalcanin.fr/cat-range/feline-health-nutrition/,"+
                "https://shop.royalcanin.fr/cat-range/dry-products/,"+
                "https://shop.royalcanin.fr/cat-range/wet-products/,"+
                "https://shop.royalcanin.fr/subscription-landing,"+
                "https://shop.royalcanin.fr/Tailorednutrition,"+
                "https://shop.royalcanin.fr/About-Us,"+
                "https://shop.royalcanin.fr/help,"+
                "https://shop.royalcanin.fr/faq,"+
                "https://shop.royalcanin.fr/Values,"+
                "https://shop.royalcanin.fr/Quality-safety,"+
                "https://shop.royalcanin.fr/general-terms-conditions,"+
                "https://shop.royalcanin.fr/on/demandware.store/Sites-FR-Site/fr_FR/Search-Show?q=@,"+
                "https://shop.royalcanin.fr/on/demandware.store/Sites-FR-Site/fr_FR/Search-Show?q=12,"+
                "https://shop.royalcanin.fr/pack-appetite-control-care-MKT30001,"+
                "https://shop.royalcanin.fr/cart,"+
                "https://shop.royalcanin.fr/checkout,"+
                "https://shop.royalcanin.fr/confirmation,"+
                "https://signin.royalcanin.com/,"+
                "https://shop.royalcanin.fr/register,"+
                "https://shop.royalcanin.fr/account,"+
                "https://shop.royalcanin.fr/account/information,"+
                "https://shop.royalcanin.fr/account/pets,"+
                "https://shop.royalcanin.fr/account/orders,"+
                "https://shop.royalcanin.fr/account/subscription,"+
                "https://shop.royalcanin.fr/product-finder,"+
                "https://shop.royalcanin.fr/product-finder-recommendation,"+
                "https://shop.royalcanin.fr/product-finder-noresult,"+
                "https://shop.royalcanin.fr/dogs/?prefn1=ages&prefv1=Adulte|Sénior,"+
                "https://shop.royalcanin.fr/cats/?prefn1=ages&prefv1=Adulte (1-7 ans)|Mature (7-12 ans)|Senior (+ 12 ans),"+
                "https://shop.royalcanin.fr/dogs/?prefn1=ages&prefv1=Chiot de 0 à 2 mois|Chiot de plus de 2 mois,"+
                "https://shop.royalcanin.fr/cats/?prefn1=ages&prefv1=Chaton (0-4 mois)|Chaton (5 mois-1 an)";
        String[] urls = urll.split(",");
        for(String url:urls){
            System.out.println("<url>");
            System.out.print("  <loc>");
            System.out.print(url);
            System.out.println("</loc>");
            System.out.println("  <lastmod>2021-01-20T03:27:56+00:00</lastmod>");
            System.out.println("  <changefreq>monthly</changefreq>");
            System.out.println("  <priority>0.8</priority>");
            System.out.println("</url>");
            System.out.println();
        }
    }
}
