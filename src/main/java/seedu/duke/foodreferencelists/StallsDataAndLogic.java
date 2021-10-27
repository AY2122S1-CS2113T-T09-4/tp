package seedu.duke.foodreferencelists;

import seedu.duke.exceptions.food.FoodIndexNotFoundException;
import seedu.duke.food.FoodRecord;
import seedu.duke.food.WhatIAteList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

//@@author ngnigel99
/**
 * This class represents the stores at a certain food court,
 * which includes the names as well as the food items sold.
 * Additionally, logic of searching for a certain food record
 * by index is implemented to support adding food by reference
 * functionality.
 */
public class StallsDataAndLogic {
    public static String nameOfFoodCentre = "techno edge, NUS";
    public static HashMap<Integer, String> idName = new HashMap<>();
    public static HashMap<Integer, String[]> idData = new HashMap<>();
    public static ArrayList<String[]> compoundedItemsList = new ArrayList<>();

    public static int MAX_STORE_INDEX = 11;

    //for easier indexing and searching
    public StallsDataAndLogic() {
        initialiseNameIdMap();
        initialiseIdPointerMap();
        collateAllItems();
    }

    private void initialiseNameIdMap() {
        idName.put(1, "Asian Delights");
        idName.put(2, "Cai Fan");
        idName.put(3, "Chicken Rice");
        idName.put(4, "Hong Kong Cuisine");
        idName.put(5, "Hungry Burger");
        idName.put(6, "Indian Cooked Food");
        idName.put(7, "Nasi Padang");
        idName.put(8, "Ramen & Fish Soup");
        idName.put(9, "Taiwanese Cuisine");
        idName.put(10, "Vegetarian");
        idName.put(11, "Western Fare");
    }

    private void initialiseIdPointerMap() {
        idData.put(1, asianDelights);
        idData.put(2, caiFan);
        idData.put(3, chickenRice);
        idData.put(4, hongKongCuisine);
        idData.put(5, hungryBurger);
        idData.put(6, indian);
        idData.put(7, nasiPadang);
        idData.put(8,ramenFish);
        idData.put(9, taiwaneseCuisine);
        idData.put(10,vegetarian);
        idData.put(11, western);
    }

    /**
     * Collates all items from all stores into array list.
     */
    private void collateAllItems() {
        idData.forEach((key,value) -> compoundedItemsList.add(value));
    }

    /**
     * Helper function to list all current stores.
     */
    public static void printStalls() {
        idName.forEach((key, value) -> Ui.printMessage(key + " | " + value));
        Ui.printMessage("Wow, thats a lot of options! Finished printing");
    }

    public static FoodRecord getFoodRecordFromStall(int storeIndex, int foodIndex)
        throws FoodIndexNotFoundException {
        if (storeIndex <= 0 || storeIndex > MAX_STORE_INDEX) {
            Ui.printMessage("Oops, can't find store " + storeIndex);
            throw new FoodIndexNotFoundException();
        }
        int itemCount = idData.get(storeIndex).length;
        if (foodIndex >= itemCount) {
            throw new FoodIndexNotFoundException();
        }
        String foodData =  idData.get(storeIndex)[foodIndex];
        FoodRecord toReturn = Parser.parseFoodSavedListToRecord(foodData);
        return toReturn;
    }


    /**
     * Prints items for a specific store with given index.
     * @param index index of the store
     */
    public static void printItems(int index) {
        if (index <= 0 || index > MAX_STORE_INDEX) {
            Ui.printMessage("Oops, can't find store " + index);
        } else {
            WhatIAteList tempFormattedList = new WhatIAteList();
            String[] itemsSold = idData.get(index);
            for (String readLine : itemsSold) {
                FoodRecord toAdd = Parser.parseFoodSavedListToRecord(readLine);
                tempFormattedList.addToList(toAdd, true);
            }
            tempFormattedList.printList(false);
        }
    }

    /**
     * Trivial function to print every item.
     */
    public static void printAllItems() {
        for (int storeIndex : idName.keySet()) {
            String storeName = idName.get(storeIndex);
            System.out.println(storeName);
            Ui.printLine();
            printItems(storeIndex);
        }
    }

    /**
     * Start of data dump, which includes items sold and calorie count.
     */
    public static final String[] asianDelights = {
        "Set A - Butterfly Plea Flower Rice w Ayam Penyet (Regular) | 1151",
        "Set A - Butterfly Plea Flower Rice w Ayam Penyet (Reduced) | 1124",
        "Set B - Butterfly Plea Flower Rice w Ayam Merah (Regular) | 667",
        "Set B - Butterfly Plea Flower Rice w Ayam Merah (Reduced) | 401",
        "Set C - Butterfly Plea Flower Rice w Ayam Bakar Boneless (Regular) | 767",
        "Set C - Butterfly Plea Flower Rice w Ayam Bakar Boneless (Reduced) | 460",
        "Set D - Butterfly Plea Flower Rice w Ayam Hijau (Regular) | 856",
        "Set D - Butterfly Plea Flower Rice w Ayam Hijau (Reduced) | 514",
        "Set E - Butterfly Plea Flower Rice w Dory (Regular) | 863",
        "Set E - Butterfly Plea Flower Rice w Dory (Reduced) | 518",
        "Set F - Butterfly Plea Flower Rice w Beef Rendang | 718",
        "Set F - Butterfly Plea Flower Rice w Bebek Penyet | 1262",
        "Value Meal | 806",
        "Kampung Seafood Mee Goreng (Spicy) | 594",
        "Indonesian Fried Rice (Spicy) | 454",
        "Thai Creamy Tom Yum Mama Noodle (Spicy) | 345",
        "Soup Buntot | 462",
        "Soup Pindang (Fish) | 130",
        "Soup Pindang (Chicken) | 137",
        "Thai Tom Yam Goong | 205",
        "Egg Dah Dah | 86",
        "Sambal Egg | 105",
        "Sambal Goreng | 66",
        "Sayur Lodeh | 266"
    };

    public static final String[] caiFan = {
        "Steamed Pork Rib | 201",
        "Chinese Leek with Tofu  | 109",
        "Kung Pao Chicken | 253",
        "Pig Liver with Spring Onion | 171",
        "Curry Chicken Drumstick | 130",
        "Stir Fried Pork Slices | 294",
        "Stir Fried Minced Pork | 181",
        "Bittergourd with Egg | 71",
        "Onion Egg | 141",
        "Stewed Potato | 143",
        "Stir Fried Nai Bai (Milk Cabbage) | 41",
        "Stir Fried Cabbage | 48",
        "Stir Fried Xiao Bai Cai | 48",
        "Stir Fried Broccoli | 51",
        "Stir Fried Long Beans | 48",
        "Stir Fried Brinjal | 63",
        "White Rice | 256",
        "Brown Rice | 233"
    };

    public static final String[] chickenRice = {
        "Roasted Chicken Rice | 556",
        "White Chicken Rice | 533",
        "Char Siew Rice | 697",
        "Roasted Pork Rice | 680",
        "Roasted Chicken Noodles (Egg Noodles) - Regular | 320",
        "Roasted Chicken Noodles (Egg Noodles) - Large | 388",
        "Roasted Chicken Noodles (Hor Fun) - Regular | 341",
        "Roasted Chicken Noodles (Hor Fun) - Large | 409",
        "White Chicken Noodles (Egg Noodles) - Regular | 307",
        "White Chicken Noodles (Egg Noodles) - Large | 365",
        "White Chicken Noodles (Hor Fun) - Regular | 328",
        "White Chicken Noodles (Hor Fun) - Large | 386",
        "Char Siew Noodles (Egg Noodles) - Regular | 410",
        "Char Siew Noodles (Egg Noodles) - Large | 529",
        "Char Siew Noodles (Hor Fun) - Regular | 431",
        "Char Siew Noodles (Hor Fun) - Large | 550",
        "Roasted Pork Noodles (Egg Noodles) - Regular | 395",
        "Roasted Pork Noodles (Egg Noodles) - Large | 511",
        "Roasted Pork Noodles (Hor Fun) - Regular | 416",
        "Roasted Pork Noodles (Hor Fun) - Large  | 533",
        "Roasted Chicken Rice, Veg, Half Egg Set Meal | 604",
        "White Chicken Rice, Veg, Half Egg Set Meal | 582",
        "Char Siew Rice, Veg, Half Egg Set Meal | 746",
        "Roasted Pork Rice, Veg, Half Egg Set Meal | 728",
        "Curry Chicken Bee Hoon | 744",
        "Curry Chicken Noodles | 777",
        "Chicken Shredded Porridge | 150",
        "Roasted Pork Rice Soup | 238"
    };

    public static final String[] hongKongCuisine = {
        "Set A - Kaya w Butter | 295",
        "Set B - Peanut w Butter | 271",
        "Set C - Kaya w Cheese  | 268",
        "Set D - Peanut Butter Thick Toast | 316",
        "French Toast w Golden Syrup  | 344",
        "Mega Breakfast  | 473",
        "Scrambled Egg w Luncheon Meat Toast  | 228",
        "HK Gong Zai Mian | 522",
        "Macaroni w Luncheon Meat Soup | 348",
        "Chicken Baked Rice | 353",
        "Mushroom Baked Rice | 172",
        "Curry Chicken Baked Rice | 358",
        "Seafood Tomato Baked Rice | 331",
        "Salmon Baked Rice | 466",
        "Scrambled Egg w Luncheon Meat Rice Bowl (Regular) | 331",
        "Scrambled Egg w Luncheon Meat Rice Bowl (Reduced) | 199",
        "Minced Chicken w Onsen Egg Rice Bowl (Regular) | 359",
        "Minced Chicken w Onsen Egg Rice Bowl (Reduced) | 176",
        "Teriyaki Chicken w Onsen Egg Rice Bowl (Regular) | 467",
        "Teriyaki Chicken w Onsen Egg Rice Bowl (Reduced) | 280",
        "Yakiniku Beef w Onsen Egg Rice Bowl (Regular) | 474",
        "Yakiniku Beef w Onsen Egg Rice Bowl (Reduced) | 284",
        "Vegetarian Fried Rice | 362",
        "Prawn Fried Rice | 466",
        "Smoked Duck & Sausages Fried Rice (Spicy) | 532",
        "Silverfish Fried Rice | 326",
        "Mala Beef Fried Rice | 505",
        "Sambal Petai w Prawns Fried Rice | 408",
        "Salmon Fried Rice | 437",
        "Steamed Milk Custard | 156",
        "Steamed Egg Custard | 197",
        "Mango Pomelo Sago | 178",
        "Mixed Fruits Pancake | 161",
        "Truffle Fries w Parmesan Cheese | 419",
        "Kopi O Kosong | 60",
        "Kopi O Siew Dai | 110",
        "Kopi O | 129",
        "Kopi | 170",
        "Kopi Siew Dai | 130",
        "Kopi C | 136",
        "Kopi C Siew Dai | 117",
        "Kopi C Kosong | 67",
        "Teh O Kosong | 6",
        "Teh O Siew Dai | 56",
        "Teh O | 76",
        "Teh | 116",
        "Teh Siew Dai | 77",
        "Teh C | 83",
        "Teh C Siew Dai | 63",
        "Teh C Kosong | 13",
        "Milo | 47",
        "Honey Lemon |  17",
        "Yuzu Tea | 7",
        "Ginger Lemon Cola  | 90",
        "Chinese Tea | 6",
        "Iced Signature HK Milk Tea | 116",
        "Iced Yuan Yang | 146",
        "Mineral Water | 0",
        "Coke | 134",
        "Coke No Sugar | 0",
        "100 Plus | 72",
        "Pokka Green Tea | 69",
        "Yeo's Soy Beann Drink | 170",
        "Hosen Orange Drink | 125",
        "Wang Lao Ji | 106"
    };

    public static final String[] hungryBurger = {
        "Value Breakfast Set A(w/ Kopi O Kosong) | 580",
        "Value Breakfast Set A(w/ Teh O Kosong) | 580",
        "Value Breakfast Set B(w/ Kopi O Kosong) | 533",
        "Value Breakfast Set B(w/ Teh O Kosong) | 533",
        "Chicken Burger Set | 607",
        "Fish Burger Set | 601",
        "Signature Beef Burger Set | 627",
        "Portobello Mushroom Burger Set | 501",
        "Double Spicy Bird Burger Set (Spicy Chicken) | 1202",
        "Avocado Garden Salad (Regular) | 441",
        "Avocado Garden Salad (Petite) | 264",
        "Cheesy Pasta Salad (Regular) | 378",
        "Cheesy Pasta Salad (Petite) | 227",
        "Zesty Ocean Salad (Regular) | 527",
        "Abiqulu Smoked Chicken Salad (Regular) | 419",
        "Abiqulu Smoked Chicken Salad (Petite) | 257",
        "Cream of Mushroom Soup with Pastry Cap | 451",
        "Cream of Corn Soup with Pastry Cap | 459",
        "Cream of Chicken Soup with Pastry Cap | 582",
        "Massive Triple Trouble Cheeseburger w/ Fries | 1028",
        "Massive Triple Trouble Cheeseburger w/ Potato Wedges | 991"
    };

    public static final String[] indian = {
        "Plain Prata | 182",
        "Egg Prata | 265",
        "Cheese Prata |233",
        "Egg & Onion Prata | 271",
        "Combo Prata | 322",
        "Plain Thosai | 136",
        "Egg Thosai | 219",
        "Cheese Thosai | 187",
        "Egg & Onion Thosai | 225",
        "Combo Thosai | 276",
        "Masala Thosai | 189",
        "Onion Vegetable Utappam | 347",
        "Briyani Rice | 268",
        "Tomato Rice | 262",
        "Nasi Goreng | 627",
        "Mee Goreng | 545",
        "Fried Chicken Drumstick | 397",
        "Curry Chicken Drumstick | 186",
        "Boneless Butter Chicken | 131",
        "Boneless Ginger Chicken | 131",
        "Black Pepper Chicken | 141",
        "Chilli Chicken | 324",
        "Mutton | 191",
        "Dory Fish | 105",
        "Fried Fish Pieces | 138",
        "Fried Dory Steak | 165",
        "Prawn | 110",
        "Sotong | 104",
        "Egg with Onion | 142",
        "Tofu | 83",
        "Chickpeas | 174",
        "Long Bean | 53",
        "Spinach | 125",
        "Broccoli & Cauliflower | 83",
        "Bittergourd | 72"
    };

    public static final String[] nasiPadang = {
        "Mee Rebus | 372",
        "Mee Siam | 317",
        "Mee Soto | 557",
        "Mee Bandung | 407",
        "Lontong | 1187",
        "Mee Goreng | 324",
        "Fried Kway Teow | 414",
        "Fried Bee Hoon | 356",
        "Mee Hong Kong | 291",
        "Nasi Goreng Pattaya | 620",
        "Chicken Briyani | 866",
        "Nasi Lemak Set 1 (Chicken Wing, Egg) | 1204",
        "Nasi Lemak Set 2 (Fish Fillet, Hotdog, Ikan Bilis | 1211",
        "Curry Puff (Potato) | 425",
        "Curry Puff (Sardine) | 461",
        "Curry Puff (Chicken) | 409",
        "Spring Roll | 212",
        "Samosa | 156",
        "Tahu Goreng | 305",
        "Malay Cake (Ma Lai Go) | 214",
        "Kuih Lopes | 480",
        "Kuih Ongol Ubi (Ubi Kayu) | 279",
        "Fried Chicken Wing | 348",
        "Stir-Fried Beansprouts | 25",
        "Kangkung Belacan | 39",
        "Braised Egg and Chicken | 209",
        "Beef Rendang | 260",
        "Gulai Ayam (Chicken Curry) | 265",
        "Sayur Lodeh (Vegetable Curry) | 141",
        "Cuttlefish (Sambal Tumis Sotong) | 59",
        "Mutton Rendang | 268",
        "Kebaru Timun (Spicy Cucumber Salad) | 511",
        "Sambal Goreng Tempeh (Fried Spicy Tempeh) | 776"
    };

    public static final String[] ramenFish = {
        "Signature Trio Eggs Spinach Soup (Regular) | 256",
        "Signature Trio Eggs Spinach Soup (Small Portion)  | 119",
        "Seafood Spinach Soup (Regular) | 188",
        "Sliced Fish Spinach Soup (Regular) |  224",
        "Sliced Fish Spinach Soup (Small Portion)| 134",
        "Fried Fish Spinach Soup (Regular) | 282",
        "Fried Fish Spinach Soup (Small Portion) | 169",
        "Double Mixed Fish Spinach Soup (Regular) | 257",
        "Double Mixed Fish Spinach Soup (Small Portion) | 191",
        "Fresh Mushrooms with Ramen (Regular) | 303",
        "Fresh Mushrooms with Ramen (Small Portion) | 182",
        "Mala Dry Ramen w Chicken Cheeseballs | 676",
        "Mala Dry Ramen w Fuzhou Fishballs | 713",
        "Mala Beef Ramen Soup | 644"
    };

    public static final String[] taiwaneseCuisine = {
        "Sunrise Sandwich (Half) | 207",
        "Sunrise Sandwich (Full) | 414",
        "Tuna & Egg Sandwich (Half) | 178",
        "Tuna & Egg Sandwich (Full) | 355",
        "Ham & Egg Sandwich (Half) | 174",
        "Ham & Egg Sandwich (Full) | 349",
        "Pork Floss & Egg Sandwich (Half) | 184",
        "Pork Floss & Egg Sandwich (Full) | 349",
        "Honey Glazed Chicken Sandwich (Half) | 274",
        "Honey Glazed Chicken Sandwich (Full) | 548",
        "Plain Egg Crepe | 218",
        "Pork Floss Crepe | 169",
        "Hot Dog Crepe | 266",
        "Ham Crepe | 160",
        "Original Scallion Pancake | 324",
        "Egg & Scallion Pancake | 393",
        "Hot Dog & Scallion Pancake | 441",
        "Cheese & Scallion Pancake | 364",
        "Cheese & Hot Dog Scallion Pancake | 480",
        "Taiwanese Scallion Pancake | 403",
        "Honey Glazed Chicken Chop | 635",
        "X-Large Chicken Chop | 703",
        "Mala Chicken Chop | 636",
        "Salted Crispy Chicken (Small) | 472",
        "Salted Crispy Chicken Medium) | 569",
        "Salted Crispy Chicken (Large) | 711",
        "Sesame Seed Crispy Chicken (Small) | 377",
        "Sesame Seed Crispy Chicken (Medium) | 509",
        "Sesame Seed Crispy Chicken (Large) | 654",
        "Honey Glazed Chicken Chop Rice (Normal) | 669",
        "Honey Glazed Chicken Chop Rice (Large) | 893",
        "X-Large Chicken Chop Rice (Normal) | 672",
        "X-Large Chicken Chop Rice (Large) | 961",
        "Mala Chicken Chop Rice (Normal) | 669",
        "Mala Chicken Chop Rice (Large) | 894",
        "Salted Crispy Chicken Rice (Normal) | 634",
        "Salted Crispy Chicken Rice (Large) | 826",
        "Sesame Seed Crispy Chicken Rice (Normal) | 634",
        "Sesame Seed Crispy Chicken Rice (Large) | 839",
        "Taiwanese Pork Chop Rice (Normal) | 1022",
        "Taiwanese Pork Chop Rice (Large) | 1115",
        "Sweet & Sour Chicken Rice (Normal) | 697",
        "Sweet & Sour Chicken Rice (Large) | 937",
        "Teriyaki Chicken Rice (Normal) | 703",
        "Teriyaki Chicken Rice (Large) | 946",
        "Taiwanese Braised Pork Rice (Normal) | 654",
        "Taiwanese Braised Pork Rice (Large) | 741"
    };

    public static final String[] vegetarian = {
        "Stir Fried Broccolli | 23",
        "Stir Fried Beansprouts | 20",
        "Stir Fried Bittergourd | 15",
        "Stir Fried Cabbage | 24",
        "Stir Fried Lotus Root | 37",
        "Stir Fried Seaweed | 45",
        "Stir Fried Tau Kwa | 71",
        "Stir Fried Golden Needle Vegetable | 42",
        "Stir Fried King Oyster Mushroom | 54",
        "Stir Fried Chinese Yam | 68",
        "Stir Fried Brinjal | 29",
        "Stir Fried Long Bean | 25",
        "Stir Fried Green Amaranth | 19",
        "Stir Fried Mushroom Mock Meat | 124",
        "Stir Fried Tau Gee Tang Hoon | 85",
        "Stir Fried Potato Fries | 110",
        "Chilli Mock Meat Bits | 96",
        "Sweet & Sour Mock Meat | 289",
        "Stewed Mock Fish Balls | 96",
        "Deep Fried Vegetable Fritter | 230",
        "Fried Noodle | 472",
        "Fried Kway Teow | 351",
        "Fried Rice | 258"
    };

    public static final String[] western = {
        "Black Pepper Chicken Chop  | 775",
        "Chicken Cutlet |  966",
        "Grilled Dory Fish | 530",
        "Fish & Chip | 838",
        "Black Pepper Ribeye Steak | 807",
        "Combo Set 1: Ribeye Steak & Grilled Chicken | 831",
        "Combo Set 2: Ribeye Steak & Grilled Fish | 680",
        "Combo Set 3: Ribeye Steak & Grilled Salmon | 776",
        "Combo Set 4: Grilled Chicken Chop & Grilled Dory Fish | 750",
        "Arrabiata | 295",
        "Pomodoro | 341",
        "Creamy Chicken Spaghetti | 755",
        "Creamy Chicken Ham & Mushroom Spaghetti | 571",
        "Prawns & Mushroom Spaghetti | 557",
        "Hot Chicken Spaghetti | 365",
        "Creamy Sausage & Mushroom Spaghetti | 688",
        "Alfredo | 651",
        "Chicken Patty Spaghetti | 530",
        "Chicken Cheese Ball Spaghetti | 501",
        "Salmon e Funghi Spaghetti | 715",
        "Seafood Marinara | 440",
        "Creamy Fish Pasta | 616",
        "Baked Beans, Fries & Sausage | 359",
        "Baked Beans, Mashed Potato & Sausage | 447"
    };
}
