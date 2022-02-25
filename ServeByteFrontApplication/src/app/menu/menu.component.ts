import { Component, OnInit } from '@angular/core';
import { Menu, Section, SubSection, Item } from '../menuObj';

@Component({
  selector: "app-menu",
  templateUrl: "./menu.component.html",
  styleUrls: ["./menu.component.css"],
})
export class MenuComponent implements OnInit {
  public objectKeys = Object.keys;
  private menu = new Menu(
    new Section({
      "native spicies": new SubSection({
        "Sonder Avo Toast": new Item(
          [
            "Fried Asun with Ponmo",
            "Fufu and Eforiro",
            "Fried Fish",
            "Garri and groundnut",
            "Beans and Fried Plantain"
          ],
          10000,
        ),
        YORU: new Item(["Amala", "Vegetable", "Rice", "Tomato"], 10000),
        "Egg Avocado": new Item(
          ["Native", "Ipala", "Feta", "Fried Egg", "Frenz-Cue"],
          10000
        ),
      }),
      Pleasure: new SubSection({
        Parfait: new Item(
          [
            "Milk Sobo",
            "Grape Juice",
            "Topped With French Fries",
          ],
          8000
        ),
        "House Assembled Toaster Strudel": new Item(
          ["Home Made Strawberry Compote", "Icing"],
          9000
        ),
        "Green Eggs & Ham": new Item(
          [
            "Prosciutto",
            "Basil Pesto Hollandaise",
            "Roasted Tomato",
            "Poached Egg",
            "English Muffin",
            "Country Potatoes or Fruit",
          ],
          12000
        ),
        "English Muffin Sandwich": new Item(
          [
            "Smoked Ham",
            "Bacon",
            "Arugula",
            "Tomato",
            "American Cheese",
            "Mayo",
            "Scrambled Egg",
            "Country Potatoes or Fruit",
          ],
          11
        ),
      }),
      aebleskivers: new SubSection({
        "Brown Sugar": new Item(
          ["Brown Sugar", "Maple Syrup", "Powdered Sugar"],
          9
        ),
        Fruited: new Item(["Berries", "Cream Cheese Filling"], 9),
        Elvis: new Item(
          ["Peanut Butter Brittle", "Banana", "Applewood Bacon"],
          9
        ),
      }),
      "brunch food": new SubSection({
        "Chicken n' Waffles": new Item(
          [
            "Fried Chicken Breast",
            "Belgian Waffle",
            "Maple Syrup",
            "Hot Sauce",
          ],
          14
        ),
        "Biscuits n' Gravy": new Item(
          [
            "Cheddar Scallion Biscuits with Gravy",
            "Jalapenos (Add #500)",
            "Egg (Add #1000)",
          ],
          11
        ),
        "Chilaquiles Burrito": new Item(
          [
            "Eggs",
            "Bacon",
            "Jack Cheese",
            "Country Potatoes",
            "Black Beans",
            "Topped with Tortilla Strips, Verde, and Red Sauce",
          ],
          11
        ),
      }),
      "drink specials": new SubSection({
        "Raspberry Sorbet Mimosa": new Item([], 8000),
        "Sonder Mimosa": new Item([], 5000),
      }),
    }),
    new Section({
      "main street emporium": new SubSection({
        Ribeye: new Item(
          ["14 Oz. Angus", "Roasted Garlic Herb Butter", "Sea Salt"],
          28
        ),
        "New York": new Item(
          ["14 Oz. Angus", "Roasted Garlic Herb Butter", "Sea Salt"],
          26
        ),
        "Center Cut Sirloin": new Item(
          ["10 Oz. Angus", "Roasted Garlic Herb Butter", "Sea Salt"],
          22
        ),
        "Fried Chicken": new Item(
          [
            "Herb Chicken",
            "Broccoli Coleslaw",
            "Mashed Potatoes",
            "Gravy",
            "Corn Bread",
          ],
          19
        ),
        Cioppino: new Item(
          [
            "Stewed Mussels",
            "Clams",
            "Shrimp",
            "Tomato",
            "Garlic",
            "White Wine",
            "Basil",
          ],
          22
        ),
        "Pork Chop": new Item(
          [
            "Double Bone-In 12 Oz. Chop",
            "Garlic Herb Pan Gravy",
            "Served With Sauteed Cauliflower and Baby Arugula",
          ],
          21
        ),
        Carbonara: new Item(
          [
            "Fresh Semolina Pasta",
            "English Peas",
            "Pancetta",
            "Parmesan",
            "White Wine Sauce",
          ],
          16
        ),
        "Roasted Chicken": new Item(
          ["Cornish Game Hen", "Bed of Quinoa and Arugula"],
          18
        ),
      }),
    }),
    new Section({
      "first things first": new SubSection({
        "Smoked Wings (Full)": new Item(
          [
            "Smoked Marinated Grilled Wings",
            "Brocolli Green Apple Slaw",
            "Alabama White BBQ Sauce",
          ],
          12
        ),
        "Smoked Wings (Half)": new Item(
          [
            "Smoked Marinated Grilled Wings",
            "Brocolli Green Apple Slaw",
            "Alabama White BBQ Sauce",
          ],
          6
        ),
        "Buffalo Cauliflower": new Item(
          ["Roasted Cauliflower tossed in Buffalo & Blue Cheese Crumbles"],
          8
        ),
        Poutine: new Item(
          [
            "Chuck Roast Gravy",
            "Mozzarella",
            "Green Onions",
            "over Beet Battered Fries",
            "Walter Habanero Salt",
          ],
          9
        ),
        "Blackened Shrimp Tacos": new Item(
          [
            "Blackened Grilled Shrimp",
            "Red Cabbage",
            "Pineapple Salsa",
            "Avocado Lime Crema",
            "Tajin",
            "Corn Tortilla",
          ],
          10
        ),
      }),
      "board & bread": new SubSection({
        "DC Burrata": new Item(
          [
            "Burrata served with Confit Tomato",
            "Orange Segment",
            "Fennel",
            "Red Onion",
            "Roasted Garlic Puree",
            "Balsamic Reduction",
            "Sea Salt",
            "EVOO",
          ],
          12
        ),
        "Smoked Salmon Board": new Item(
          [
            "Tomatoes",
            "Mushroom",
            "Avocado",
            "Lemons",
            "Capers",
            "Pickled Onions",
          ],
          15
        ),
        Cheese: new Item(
          [
            "Three Seasonal Cheeses",
            "Seasonal Nuts",
            "Home Made Compote",
            "Grapes",
            "Roasted Golden Beets",
            "Home Made Fig Spread",
          ],
          14
        ),
        Charcuterie: new Item(
          [
            "Two Seasonal Meats",
            "Two Seasonal Cheeses",
            "Seasonal Nuts",
            "Roasted Tomatoes",
            "Grapes",
            "Roasted Golden Beets",
            "Fig Spread",
          ],
          16
        ),
        "Pub Board": new Item(
          [
            "Smoked Uncured Ham",
            "Pepperoni",
            "Parmesan",
            "Manchego",
            "Seasonal Nuts",
            "Beer Mustard",
            "Oven Dried Tomatoes",
            "Seasonal Compote",
            "14 Day House Pickles",
          ],
          14
        ),
      }),
      salads: new SubSection({
        Poke: new Item(
          [
            "Ahi Tuna",
            "Edamame",
            "Avocado",
            "Radish",
            "Cilantro",
            "Black Sesame Seed",
            "Wonton Crisp",
            "Togarashi",
            "Cucumber",
            "Bed of Mixed Greens",
            "Ponzu Dressing",
          ],
          14
        ),
        "Super Food": new Item(
          [
            "Kale",
            "Quinoa",
            "Avocado",
            "Golden Beets",
            "Confit Tomato",
            "Toasted Sunflower Seeds",
            "Lemon Vinaigrette",
          ],
          10
        ),
        "Chopped Cobb": new Item(
          [
            "Chicken",
            "Bacon",
            "Tomato",
            "Hard Boiled Eggs",
            "Avocado",
            "Red Onion",
            "Blue Cheese Crumble",
          ],
          11
        ),
        Southern: new Item(
          [
            "Brussel Sprout Petal Bed",
            "Bacon",
            "Pickled Chow Chow",
            "Cheddar Biscuit Croutons",
            "Smoked Honey Vinaigrette",
          ],
          12
        ),
        "Chicken Caesar": new Item(["Romaine", "Parmesan", "Herb Croutons"], 9),
      }),
      "bruchetta board": new SubSection({
        Savory: new Item(
          [
            "Pesto Spread",
            "Salami",
            "Pepperoni",
            "Fried Sage",
            "Roasted Tomatoes",
          ],
          3
        ),
        Sweet: new Item(
          ["Brie", "Green Apple", "Fig Jam", "Arugula", "Lemon Vinaigrette"],
          3
        ),
        Smoked: new Item(
          [
            "Smoked Honey Salmon",
            "Chive Creme Fraiche",
            "Fried Capers",
            "Pickled Red Onions",
            "Arugula",
            "Lemon Vinaigrette",
          ],
          3
        ),
        OG: new Item(
          [
            "Sliced Roma Tomatoes",
            "Basil",
            "Balsamic Reduction",
            "Parmesan",
            "EVOO",
          ],
          3
        ),
        Greek: new Item(["Olive Tapenade", "Feta", "Tzatziki", "Tomatoes"], 3),
        Smores: new Item(
          ["Nutella", "Toasted Marshmellow Puff", "Orange Zest"],
          3
        ),
        Duxelle: new Item(
          [
            "Roasted Mushrooms",
            "Caramelized Onions",
            "Brie",
            "Balsamic Reduction",
          ],
          3
        ),
        Seasonal: new Item(
          ["Goat Cheese", "Home Made Apricot Jam", "Arugula"],
          3
        ),
      }),
      burgers: new SubSection({
        "Sonder Burger": new Item(
          [
            "Two 4oz Angus Patties",
            "Cheddar Cheese",
            "14-Day House Pickles",
            "French Onion House Spread",
            "Brioche Bun",
            "Served With French Fries",
          ],
          13
        ),
        "MacLoche Burger": new Item(
          [
            "Two 4oz Angus Patties",
            "Buffalo Bacon Mac n' Cheese",
            "Brioche Bun",
            "Pickles (Optional)",
            "Served With French Fries",
          ],
          13
        ),
        Burger: new Item(
          [
            "Two 4oz Angus Patties",
            "American Cheese",
            "Tomato",
            "Lettuce",
            "Red Onion",
            "Mayo",
            "Pickles",
            "Brioche Bun",
            "Served With French Fries",
          ],
          11
        ),
        "Patty Melt": new Item(
          [
            "Two 4oz Angus Patties",
            "Swiss Cheese",
            "Red Russian Dressing",
            "Caramelized Onions",
            "Toasted Rye Bread",
            "14-Day House Pickles Served On The Side",
          ],
          12
        ),
      }),
      sandwiches: new SubSection({
        "Sputnik Melt": new Item(
          [
            "Open Faced Carved Turkey",
            "Red Russian Coleslaw",
            "Swiss Cheese",
            "Toasted Rye",
            "Russian Dressing Spread",
            "Gravy Served On The Side",
          ],
          12
        ),
        "Pork Belly Banh Mi": new Item(
          [
            "Pork Belly",
            "Horse Pickled Radish & Carrot",
            "Cilantro",
            "Sliced Jalapeno",
            "Mayo",
            "French Roll",
          ],
          13
        ),
        Cubano: new Item(
          [
            "Uncured Ham",
            "Pork Belly",
            "14-Day House Pickles",
            "Swiss Cheese",
            "Yellow Mustard",
            "Brick Pressed",
          ],
          14
        ),
        Grinder: new Item(
          [
            "Pepperoni",
            "Salami",
            "Provolone",
            "Lettuce",
            "Tomato",
            "Onion",
            "Olives",
            "Oregano",
            "Vinaigrette",
            "Mayo",
            "Pepperoncini",
          ],
          11
        ),
        Caprese: new Item(
          [
            "Pesto",
            "Mozzarella",
            "Tomato",
            "Balsamic",
            "Sea Salt",
            "EVOO",
            "Add Avocado (#1500)",
            "Add Chicken/Salmon (#2500)",
            "Add Shrimp (#3000)",
          ],
          9
        ),
      }),
      sides: new SubSection({
        "French Fries": new Item([], 1500),
        "Mac & Cheese": new Item([], 2000),
        "Mashed Potatoes": new Item([], 1500),
        "Side Salad": new Item([], 1500),
        "Seasonal Veggies": new Item([], 1000),
        "Alabama White Coleslaw": new Item([], 1000),
        "Potato Chips - IPA Walter Salt": new Item([], 1000),
      }),
    })
  );

  private brunch: object;
  private dinner: object;
  private daily: object;

  constructor() {}

  ngOnInit() {
    this.brunch = this.menu.getAllBrunch();
    this.dinner = this.menu.getAllDinner();
    this.daily = this.menu.getAllDaily();
  }
}
