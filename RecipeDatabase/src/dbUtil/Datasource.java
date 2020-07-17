package dbUtil;

import javafx.scene.image.Image;
import recipe.Recipe;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Datasource {

    public static final String DB_NAME = "RecipeDatabase.db";
    public static final String SQCONN = "jdbc:sqlite:/Users/jessereinhalter/Library/" +
            "Mobile Documents/com~apple~CloudDocs/School/Udemy/Java Course/RecipeDatabase/" + DB_NAME;

    // Recipes tables
    public static final String TABLE_RECIPES = "reipes";
    public static final String COLUMN_RECIPE_ID = "_id";
    public static final String COLUMN_FILE1 = "file";
    public static final String COLUMN_FILE2 = "file2";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MAIN_FOOD = "mfood";
    public static final String COLUMN_SIDE_FOOD_ONE = "sfood1";
    public static final String COLUMN_SIDE_FOOD_TWO = "sfood2";
    public static final String COLUMN_SIDE_FOOD_THREE = "sfood3";
    public static final String COLUMN_CUISINE = "cuisine";

    // Request Recipe Names based on Cuisine
    public static final String QUERY_RECIPE_NAMES_BY_CUISINE =
            "SELECT " + COLUMN_NAME + " FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_CUISINE + " = ?";

    // Request Recipe Image 1 based on Cuisine
    public static final String QUERY_RECIPE_FILE1_BY_CUISINE =
            "SELECT " + COLUMN_FILE1 + " FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_CUISINE + " = ?";

    // Request Recipe Image 2 based on Cuisine
    public static final String QUERY_RECIPE_FILE2_BY_CUISINE =
            "SELECT " + COLUMN_FILE2 + " FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_CUISINE + " = ?";

    // Request Recipe Names based on Cuisine and Main Food
    public static final String QUERY_RECIPE_NAMES_BY_CUISINE_AND_MAIN_FOOD =
            "SELECT " + COLUMN_NAME + " FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_CUISINE + " = ?" + " AND " + COLUMN_MAIN_FOOD + " = ?";

    // Request Recipe Image 1 based on Cuisine and Main Food
    public static final String QUERY_RECIPE_FILE1_BY_CUISINE_AND_MAIN_FOOD =
            "SELECT " + COLUMN_FILE1 + " FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_CUISINE + " = ?" + " AND " + COLUMN_MAIN_FOOD + " = ?";

    // Request Recipe Image 2 based on Cuisine and Main Food
    public static final String QUERY_RECIPE_FILE2_BY_CUISINE_AND_MAIN_FOOD =
            "SELECT " + COLUMN_FILE2 + " FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_CUISINE + " = ?" + " AND " + COLUMN_MAIN_FOOD + " = ?";

    // Request all Cuisines names from table
    public static final String QUERY_COLUMN_CUISINE_FROM_TABLE_RECIPES =
            "SELECT " + COLUMN_CUISINE + " FROM " + TABLE_RECIPES;

    // Request Recipe Names based on Main Food Only
    public static final String QUERY_RECIPE_NAMES_BY_MAIN_FOOD =
            "SELECT " + COLUMN_NAME + " FROM " + TABLE_RECIPES + " WHERE " +
                    COLUMN_MAIN_FOOD + " = ?";

    // Request Recipe Image 1 based on One Main Food Only
    public static final String QUERY_RECIPE_FILE1_BY_ONE_MAIN_FOOD =
            "SELECT " + COLUMN_FILE1 + " FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_MAIN_FOOD + " = ?";

    // Request Recipe Image 2 based on One Main Food Only
    public static final String QUERY_RECIPE_FILE2_BY_ONE_MAIN_FOOD =
            "SELECT " + COLUMN_FILE2 + " FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_MAIN_FOOD + " = ?";


    // Request all recipes based on 1 main food
    public static final String QUERY_ALL_RECIPES_BY_ONE_MAIN_FOOD =
            "SELECT * FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_MAIN_FOOD + " = ?";

    // Request all recipes based on Cuisine
    public static final String QUERY_ALL_RECIPES_BY_CUISINE =
            "SELECT * FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_CUISINE + " = ?";

    // Requests all recipes based on Cuisine and Main Food
    public static final String QUERY_ALL_RECIPES_BY_CUISINE_AND_MAIN_FOOD =
            "SELECT * FROM " + TABLE_RECIPES +
                    " WHERE " + COLUMN_CUISINE + " = ?" + " AND " +
                    COLUMN_MAIN_FOOD + " =?";

    // Request all recipes
    public static final String QUERY_ALL_RECIPES =
            "SELECT * FROM " + TABLE_RECIPES;


    // Database Connection
    private Connection conn;
    private PreparedStatement queryNameByCuisine;
    private PreparedStatement queryFile1ByCuisine;
    private PreparedStatement queryFile2ByCuisine;
    private PreparedStatement queryNameByCuisineAndMainFood;
    private PreparedStatement queryFile1ByCuisineAndMainFood;
    private PreparedStatement queryFile2ByCuisineAndMainFood;
    private PreparedStatement queryAllCuisinesFromTable;
    private PreparedStatement queryNameByOneMainFood;
    private PreparedStatement queryFile1yOneMainFood;
    private PreparedStatement queryFile2ByMainFood;
    private PreparedStatement queryAllRecipesByOneMainFood;
    private PreparedStatement queryAllRecipesByCuisine;
    private PreparedStatement queryAllRecipesByCuisineAndMainFood;
    private PreparedStatement queryAllRecipes;

    // Open and Close Database connections
    public Boolean open() {
        try {
            conn = DriverManager.getConnection(SQCONN);
            queryNameByCuisine = conn.prepareStatement(QUERY_RECIPE_NAMES_BY_CUISINE);
            queryFile1ByCuisine = conn.prepareStatement(QUERY_RECIPE_FILE1_BY_CUISINE);
            queryFile2ByCuisine = conn.prepareStatement(QUERY_RECIPE_FILE2_BY_CUISINE);
            queryNameByCuisineAndMainFood = conn.prepareStatement(QUERY_RECIPE_NAMES_BY_CUISINE_AND_MAIN_FOOD);
            queryFile1ByCuisineAndMainFood = conn.prepareStatement(QUERY_RECIPE_FILE1_BY_CUISINE_AND_MAIN_FOOD);
            queryFile2ByCuisineAndMainFood = conn.prepareStatement(QUERY_RECIPE_FILE2_BY_CUISINE_AND_MAIN_FOOD);
            queryAllCuisinesFromTable = conn.prepareStatement(QUERY_COLUMN_CUISINE_FROM_TABLE_RECIPES);
            queryNameByOneMainFood = conn.prepareStatement(QUERY_RECIPE_NAMES_BY_MAIN_FOOD);
            queryFile1yOneMainFood = conn.prepareStatement(QUERY_RECIPE_FILE1_BY_ONE_MAIN_FOOD);
            queryFile2ByMainFood = conn.prepareStatement(QUERY_RECIPE_FILE2_BY_ONE_MAIN_FOOD);
            queryAllRecipesByOneMainFood = conn.prepareStatement(QUERY_ALL_RECIPES_BY_ONE_MAIN_FOOD);
            queryAllRecipesByCuisine = conn.prepareStatement(QUERY_ALL_RECIPES_BY_CUISINE);
            queryAllRecipesByCuisineAndMainFood = conn.prepareStatement(QUERY_ALL_RECIPES_BY_CUISINE_AND_MAIN_FOOD);
            queryAllRecipes = conn.prepareStatement(QUERY_ALL_RECIPES);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {

            if(queryAllRecipes != null) {
                queryAllRecipes.close();
            }

            if(queryAllRecipesByCuisineAndMainFood != null) {
                queryAllRecipesByCuisineAndMainFood.close();
            }

            if(queryAllRecipesByCuisine != null) {
                queryAllRecipesByCuisine.close();
            }

            if(queryAllRecipesByOneMainFood != null) {
                queryAllRecipesByOneMainFood.close();
            }

            if(queryFile2ByMainFood != null) {
                queryFile2ByMainFood.close();
            }

            if(queryFile1yOneMainFood != null) {
                queryFile1yOneMainFood.close();
            }
            if(queryNameByOneMainFood != null) {
                queryNameByOneMainFood.close();
            }

            if(queryAllCuisinesFromTable != null) {
                queryAllCuisinesFromTable.close();
            }

            if(queryFile2ByCuisineAndMainFood != null) {
                queryFile2ByCuisineAndMainFood.close();
            }

            if(queryFile1ByCuisineAndMainFood != null) {
                queryFile1ByCuisineAndMainFood.close();
            }

            if(queryNameByCuisineAndMainFood != null) {
                queryNameByCuisineAndMainFood.close();
            }

            if(queryFile2ByCuisine != null) {
                queryFile2ByCuisine.close();
            }

            if(queryFile1ByCuisine != null) {
                queryFile1ByCuisine.close();
            }

            if(queryNameByCuisine != null) {
                queryNameByCuisine.close();
            }

            if(conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    // Query Recipe Names by Cuisine method
    public String getRecipeNamesByCuisine(String cuisine) {
        try {
            queryNameByCuisine.setString(1, cuisine);
            ResultSet results = queryNameByCuisine.executeQuery();

            String recipeName = null;
            while (results.next()) {
                recipeName = results.getString(1);
            }
            return recipeName;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Query Recipe Image 1 by Cuisine
    public Image getRecipeTitleImageByCuisine(String cuisine) {
        try {
            queryFile1ByCuisine.setString(1, cuisine);
            ResultSet results = queryFile1ByCuisine.executeQuery();
            byte[] byteArr = results.getBytes("file");
            return new Image(new ByteArrayInputStream(byteArr));
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Query Recipe Image 2 by Cuisine
    public Image getRecipeInstructionsImageByCuisine(String cuisine) {
        try {
            queryFile2ByCuisine.setString(1, cuisine);
            ResultSet results = queryFile2ByCuisine.executeQuery();
            byte[] byteArr = results.getBytes("file2");
            return new Image(new ByteArrayInputStream(byteArr));
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Query Recipe Names by Cuisine and Main Food method
    public String getRecipeNamesByCuisineAndMainFood(String cuisine, String mainFood) {
       try {
           queryNameByCuisineAndMainFood.setString(1, cuisine);
           queryNameByCuisineAndMainFood.setString(2, mainFood);
           ResultSet results = queryNameByCuisineAndMainFood.executeQuery();

           String recipeName = null;
           while (results.next()) {
               recipeName = results.getString(1);
           }
           return recipeName;

       } catch (SQLException e) {
           System.out.println("Query failed: " + e.getMessage());
           return null;
       }
    }

    // Query All Cuisines from Table
    public ArrayList<String> getAllCuisinesFromTable() {
        try {

            ResultSet results = queryAllCuisinesFromTable.executeQuery();
            ArrayList<String> cuisineList = new ArrayList<>();
            while (results.next()) {
                String cuisine = results.getString("cuisine");
                cuisineList.add(cuisine);
            }
            return cuisineList;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Query Recipe Image 1 by Cuisine and Main Food method
    public Image getRecipeTitleImageByCuisineAndMainFood(String cuisine, String mainFood) {
        try {
            queryFile1ByCuisineAndMainFood.setString(1, cuisine);
            queryFile1ByCuisineAndMainFood.setString(2, mainFood);
            ResultSet results = queryFile1ByCuisineAndMainFood.executeQuery();

            byte[] byteArr = results.getBytes("file");
            return new Image(new ByteArrayInputStream(byteArr));


        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Query Recipe Image 2 by Cuisine and Main Food method
    public Image getRecipeInstructionImageByCuisineAndMainFood(String cuisine, String mainFood) {
        try {
            queryFile2ByCuisineAndMainFood.setString(1, cuisine);
            queryFile2ByCuisineAndMainFood.setString(2, mainFood);
            ResultSet results = queryFile2ByCuisineAndMainFood.executeQuery();

            byte[] byteArr = results.getBytes("file2");
            return new Image(new ByteArrayInputStream(byteArr));


        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Query Recipe Names by One Main Food method
    public String getRecipeNamesByOneMainFood(String mFood) {
        try {
            queryNameByOneMainFood.setString(1, mFood);
            ResultSet results = queryNameByOneMainFood.executeQuery();

            String recipeName = null;
            while (results.next()) {
                recipeName = results.getString(1);
            }
            return recipeName;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Query Recipe Image 1 by One Main Food
    public Image getRecipeTitleImageByOneMainFood(String mFood) {
        try {
            queryFile1yOneMainFood.setString(1, mFood);
            ResultSet results = queryFile1yOneMainFood.executeQuery();
            byte[] byteArr = results.getBytes("file");
            return new Image(new ByteArrayInputStream(byteArr));

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Query Recipe Image 2 by One Main Food
    public Image getRecipeInstructionsImageByOneMainFood(String mfood) {
        try {
            queryFile2ByMainFood.setString(1, mfood);
            ResultSet results = queryFile2ByMainFood.executeQuery();
            byte[] byteArr = results.getBytes("file2");
            return new Image(new ByteArrayInputStream(byteArr));

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Query All Recipes by One Main Food
    public ArrayList<Recipe> getAllRecipesByOneMainFood(String mFood) {
        try {

            ArrayList<Recipe> recipeList = new ArrayList<>();
            queryAllRecipesByOneMainFood.setString(1, mFood);
            ResultSet results = queryAllRecipesByOneMainFood.executeQuery();
            while (results.next()) {
                Recipe recipe = new Recipe();
                recipe.set_id(results.getInt("_id"));
                byte[] byteArr = results.getBytes("file");
                recipe.setFile1(new Image(new ByteArrayInputStream(byteArr)));
                byte[] byteArr2 = results.getBytes("file2");
                recipe.setFile2(new Image(new ByteArrayInputStream(byteArr2)));
                recipe.setName(results.getString("name"));
                recipe.setmFood(results.getString("mfood"));
                recipe.setsFood1(results.getString("sfood1"));
                recipe.setsFood2(results.getString("sfood2"));
                recipe.setsFood3(results.getString("sfood3"));
                recipe.setCuisine(results.getString("cuisine"));
                recipeList.add(recipe);
            }
            return recipeList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Query All Recipes by Cuisine
    public ArrayList<Recipe> getAllRecipesByCuisine(String cuisine) {
        try {
            ArrayList<Recipe> recipeList = new ArrayList<>();
            queryAllRecipesByCuisine.setString(1, cuisine);
            ResultSet results = queryAllRecipesByCuisine.executeQuery();
            while (results.next()) {
                Recipe recipe = new Recipe();
                recipe.set_id(results.getInt("_id"));
                byte[] byteArr = results.getBytes("file");
                recipe.setFile1(new Image(new ByteArrayInputStream(byteArr)));
                byte[] byteArr2 = results.getBytes("file2");
                recipe.setFile2(new Image(new ByteArrayInputStream(byteArr2)));
                recipe.setName(results.getString("name"));
                recipe.setmFood(results.getString("mfood"));
                recipe.setsFood1(results.getString("sfood1"));
                recipe.setsFood2(results.getString("sfood2"));
                recipe.setsFood3(results.getString("sfood3"));
                recipe.setCuisine(results.getString("cuisine"));
                recipeList.add(recipe);
            }

            return recipeList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Query All Recipes by Cuisine and Main Food
    public ArrayList<Recipe> getAllRecipesByCuisineAndMainFood(String cuisine, String mFood) {
        try {
            ArrayList<Recipe> recipeList = new ArrayList<>();
            queryAllRecipesByCuisineAndMainFood.setString(1, cuisine);
            queryAllRecipesByCuisineAndMainFood.setString(2, mFood);
            ResultSet results = queryAllRecipesByCuisineAndMainFood.executeQuery();
            while (results.next()) {
                Recipe recipe = new Recipe();
                recipe.set_id(results.getInt("_id"));
                byte[] byteArr = results.getBytes("file");
                recipe.setFile1(new Image(new ByteArrayInputStream(byteArr)));
                byte[] byteArr2 = results.getBytes("file2");
                recipe.setFile2(new Image(new ByteArrayInputStream(byteArr2)));
                recipe.setName(results.getString("name"));
                recipe.setmFood(results.getString("mfood"));
                recipe.setsFood1(results.getString("sfood1"));
                recipe.setsFood2(results.getString("sfood2"));
                recipe.setsFood3(results.getString("sfood3"));
                recipe.setCuisine(results.getString("cuisine"));
                recipeList.add(recipe);
            }
            return recipeList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Recipe> getAllRecipes() {
        try {
            ArrayList<Recipe> recipeList = new ArrayList<>();
            ResultSet results = queryAllRecipes.executeQuery();
            while (results.next()) {
                Recipe recipe = new Recipe();
                recipe.set_id(results.getInt("_id"));
                byte[] byteArr = results.getBytes("file");
                recipe.setFile1(new Image(new ByteArrayInputStream(byteArr)));
                byte[] byteArr2 = results.getBytes("file2");
                recipe.setFile2(new Image(new ByteArrayInputStream(byteArr2)));
                recipe.setName(results.getString("name"));
                recipe.setmFood(results.getString("mfood"));
                recipe.setsFood1(results.getString("sfood1"));
                recipe.setsFood2(results.getString("sfood2"));
                recipe.setsFood3(results.getString("sfood3"));
                recipe.setCuisine(results.getString("cuisine"));
                recipeList.add(recipe);
            }
            return recipeList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



//    // Query Recipe Image 1 by Cuisine
//    public Image getRecipeTitleImage(String cuisine) throws SQLException {
//
//        Image image = null;
//
//        StringBuilder sb = new StringBuilder(QUERY_RECIPE_FILE1_BY_CUISINE);
//        sb.append("\"");
//        sb.append(cuisine);
//        sb.append("\"");
//
//        System.out.println("SQL statement = " + sb.toString());
//
//        try (Statement statement = conn.createStatement();
//             ResultSet rs = statement.executeQuery(sb.toString())){
//
//            byte[] byteArr = rs.getBytes("file");
//            image = new Image(new ByteArrayInputStream(byteArr));
//
//            return image;
//
//        } catch (SQLException e) {
//            System.out.println("Query failed: " + e.getMessage());
//            return null;
//        }
//    }



//    // Query Recipe Image 2 by Cuisine
//    public Image getRecipeInstructionsImage(String cuisine) throws SQLException {
//
//        Image image = null;
//
//        StringBuilder sb = new StringBuilder(QUERY_RECIPE_FILE2_BY_CUISINE);
//        sb.append("\"");
//        sb.append(cuisine);
//        sb.append("\"");
//
//        System.out.println("SQL statement = " + sb.toString());
//
//        try (Statement statement = conn.createStatement();
//             ResultSet rs = statement.executeQuery(sb.toString())) {
//            byte[] byteArr = rs.getBytes("file2");
//            image = new Image(new ByteArrayInputStream(byteArr));
//        }
//        return image;
//    }
}

