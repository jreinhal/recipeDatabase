package com.jessereinhalter;


import dbUtil.Datasource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import recipe.Recipe;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;



public class RecipeDatabaseController implements Initializable {

    Datasource datasource = new Datasource();
    Recipe recipe = new Recipe();
    ArrayList<Recipe> recipeList = new ArrayList<>();
    ObservableList<String> recipeListNames = FXCollections.observableArrayList();
    ObservableList<String> ingredientRecipeListNames = FXCollections.observableArrayList();
    ArrayList<Recipe> removedRecipeList = new ArrayList<>();
    ObservableList<Recipe> ingredientRecipeList = FXCollections.observableArrayList();
    int numberOfBoxesChecked = 0;

    @FXML
    ListView<String> recipeListView;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView imageView2;
    @FXML
    ComboBox<String> comboBox;
    @FXML
    private CheckBox groundBeefCB;
    @FXML
    private CheckBox chickenCB;
    @FXML
    private CheckBox groundPorkCB;
    @FXML
    private CheckBox fishCB;
    @FXML
    private CheckBox tofuCB;
    @FXML
    private CheckBox steakCB;
    @FXML
    private CheckBox porkChopsCB;
    @FXML
    private CheckBox pastaCB;
    @FXML
    private Label addIngredientsLabel;
    @FXML
    private VBox foodVBox1;
    @FXML
    private VBox foodVBox2;
    @FXML
    HBox sideFoodHBox;
    @FXML
    VBox recipeNameVBox;
    @FXML
    Button addRecipeFileBtn;
    @FXML
    private Label sideFoodLabel;
    @FXML
    private Button searchIngredientsBtn;
    // Ingredient Checkboxes
    @FXML
    private CheckBox tortillasCB, cheeseCB, avocadoCB, onionsCB, carrotsCB, lettuceCB, zucchiniCB, arugalaCB;
    @FXML
    private CheckBox beefStirFryCB, venisonCB, lambCB, shrimpCB, crabCB, tempehCB, whiteRiceCB, brownRiceCB;
    @FXML
    private CheckBox farroCB, cuscusCB, freekehCB, polentaCB, blackBeansCB, garbanzoCB;
    @FXML
    private VBox ingredientVBox;




//     Ingredient checkboxes handler
    EventHandler ingredientCheckBoxEventHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            CheckBox chk = (CheckBox) event.getSource();

            // If a checkbox is checked
            boolean b = (event.getSource() instanceof CheckBox);

            System.out.println("CB Checked = " + ((CheckBox) event.getSource()).getText());
            // If Ground Beef Checkbox is checked
            if (b == "Ground Beef".equals(chk.getText())) {
                if(groundBeefCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    // Add Recipes with an ingredient of checkbox to ingredientRecipeList
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                }
                // If Ground Beef is unchecked
                else {
                    System.out.println("Deselected checked " + chk.getText());
                    // Clear ingredientList of Recipes with unchecked ingredient checkbox
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Beef Stir Fry Checkbox is checked
            if (b == "Beef Stir Fry".equals(chk.getText())) {
                if(beefStirFryCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Steak Checkbox is checked
            if (b == "Steak".equals(chk.getText())) {
                if(steakCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Venison Checkbox is checked
            if (b == "Venison".equals(chk.getText())) {
                if(venisonCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Chicken Checkbox is checked
            if (b == "Chicken".equals(chk.getText())) {
                if(chickenCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Pork Chops Checkbox is checked
            if (b == "Pork Chops".equals(chk.getText())) {
                if(porkChopsCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Ground Pork Checkbox is checked
            if (b == "Ground Pork".equals(chk.getText())) {
                if(groundPorkCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Lamb Checkbox is checked
            if (b == "Lamb".equals(chk.getText())) {
                if(lambCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Fish Checkbox is checked
            if (b == "Fish".equals(chk.getText())) {
                if(fishCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Shrimp Checkbox is checked
            if (b == "Shrimp".equals(chk.getText())) {
                if(shrimpCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Crab Checkbox is checked
            if (b == "Crab".equals(chk.getText())) {
                if(crabCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Tofu Checkbox is checked
            if (b == "Tofu".equals(chk.getText())) {
                if(tofuCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Tempeh Checkbox is checked
            if (b == "Tempeh".equals(chk.getText())) {
                if(tempehCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If White Rice Checkbox is checked
            if (b == "White Rice".equals(chk.getText())) {
                if(whiteRiceCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Brown Rice Checkbox is checked
            if (b == "Brown Rice".equals(chk.getText())) {
                if(brownRiceCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Farro Checkbox is checked
            if (b == "Farro".equals(chk.getText())) {
                if(farroCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Cuscus Checkbox is checked
            if (b == "Cuscus".equals(chk.getText())) {
                if(cuscusCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Freekeh Checkbox is checked
            if (b == "Freekeh".equals(chk.getText())) {
                if(freekehCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Polenta Checkbox is checked
            if (b == "Polenta".equals(chk.getText())) {
                if(polentaCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Black Beans Checkbox is checked
            if (b == "Black Beans".equals(chk.getText())) {
                if(blackBeansCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }

            // If Garbanzo Checkbox is checked
            if (b == "Garbanzo".equals(chk.getText())) {
                if (garbanzoCB.isSelected()) {
                    System.out.println("Selection checked " + chk.getText());
                    addIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked += 1;
                } else {
                    System.out.println("Deselected checked " + chk.getText());
                    removeIngredientRecipe(chk.getText().toLowerCase());
                    numberOfBoxesChecked -= 1;
                }
            }
            


            // If no checkboxes are checked
            if(numberOfBoxesChecked == 0) {
                ingredientRecipeList.clear();
                ingredientRecipeListNames.clear();
                recipeListView.setItems(recipeListNames);
                selectFirstListViewEntry();
            } else {
                // Clear ingredientRecipeListNames to allow for repopulating with currently selected checkbox name(s)
                ingredientRecipeListNames.clear();
                // Create an observable list of recipe names
                for (Recipe recipe : ingredientRecipeList) {
                    if (!(ingredientRecipeListNames.contains(recipe.getName()))){
                        ingredientRecipeListNames.add(recipe.getName());
                    }
                }

                recipeListView.setItems(ingredientRecipeListNames);
                selectFirstListViewEntry();
                if(ingredientRecipeListNames.isEmpty()) {
                    imageView.setImage(null);
                    imageView2.setImage(null);
                }
            }
            System.out.println("Ing name list " + ingredientRecipeListNames.toString());
        }
    };

    // Recipe Add File Button event handler
    @FXML
    private void locateFile(ActionEvent event) throws IOException {
        Stage recipeAddStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("addRecipeFXML.fxml"));
        recipeAddStage.setTitle("Add Recipe");
        recipeAddStage.setScene(new Scene(root, 600, 500));
//        root.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        recipeAddStage.setResizable(false);
        recipeAddStage.initModality(Modality.APPLICATION_MODAL);
        //setUserAgentStylesheet(STYLESHEET_CASPIAN);
        recipeAddStage.show();
    }


    // ComboBox event handler. Determines Cuisine selection
    EventHandler comboBoxEventHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String cuisine;
            String mFood;
            String recipeName;
            ObservableList<Recipe> items = FXCollections.observableArrayList();

            // Clear ListView
            recipeListView.getItems().clear();

            // Clear ingredientList
            ingredientRecipeList.clear();

            // De-Select all checkboxes (Find a way to perform this in mass)
            groundBeefCB.setSelected(false);
            groundPorkCB.setSelected(false);
            beefStirFryCB.setSelected(false);
            steakCB.setSelected(false);
            venisonCB.setSelected(false);
            chickenCB.setSelected(false);
            porkChopsCB.setSelected(false);
            lambCB.setSelected(false);
            fishCB.setSelected(false);
            shrimpCB.setSelected(false);
            crabCB.setSelected(false);
            tofuCB.setSelected(false);
            tempehCB.setSelected(false);
            whiteRiceCB.setSelected(false);
            brownRiceCB.setSelected(false);
            farroCB.setSelected(false);
            cuscusCB.setSelected(false);
            freekehCB.setSelected(false);
            polentaCB.setSelected(false);
            blackBeansCB.setSelected(false);
            garbanzoCB.setSelected(false);


            // Determine if a cuisine was entered
            if (event.getSource() instanceof ComboBox) {
                ComboBox cb = (ComboBox) event.getSource();

                if (!(cb.getValue() == null)) {
                    if (cb.getValue().toString().equals("All Cuisines")) {
                        // Create a Recipe ArrayList of all recipes
                        recipeList = datasource.getAllRecipes();
                    } else {
                        cuisine = cb.getValue().toString().toLowerCase();
                        // Create a Recipe ArrayList based on Cuisine Selection
                        recipeList = datasource.getAllRecipesByCuisine(cuisine);
                    }

                    // Convert ArrayList recipeList into ObservableList of Recipe names
                    for (Recipe recipe : recipeList) {
                        recipeListNames.add(recipe.getName());
                    }

                    // Populate listView with recipe name
                    recipeListView.setItems(recipeListNames);
                    selectFirstListViewEntry();

                    // Enable Ingredients and listView
                    ingredientVBox.setVisible(true);
                    recipeNameVBox.setVisible(true);


                } else if (cb.getValue() == null) {

                    // Disable Ingredients and listView
                    ingredientVBox.setVisible(false);
                    recipeNameVBox.setVisible(false);

                    // Clear Lists
                    recipeListNames.clear();
                    recipeList.clear();
                    ingredientRecipeList.clear();

                    // Clear Image Views
                    imageView.setImage(null);
                    imageView2.setImage(null);
                }
            }
        }
    };


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!datasource.open()) {
            System.out.println("Not Connnected");
        } else {
            System.out.println("Connected");
        }
        // Populate combo box with cuisines
        ArrayList<String> cuisines = new ArrayList<>();
        cuisines.add("All Cuisines");
        cuisines.add("American");
        cuisines.add("Asian");
        cuisines.add("BBQ");
        cuisines.add("Cajun");
        cuisines.add("French");
        cuisines.add("Fusion");
        cuisines.add("Indian");
        cuisines.add("Mexican");

        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll(cuisines);
        comboBox.setItems(data);
        comboBox.getItems().add(0, null);

        // Set Action Handler for ComboBox
        comboBox.setOnAction(comboBoxEventHandler);

        // Set Action Handlers for Main Food Checkboxes
        groundPorkCB.setOnAction(ingredientCheckBoxEventHandler);
        groundBeefCB.setOnAction(ingredientCheckBoxEventHandler);
        beefStirFryCB.setOnAction(ingredientCheckBoxEventHandler);
        steakCB.setOnAction(ingredientCheckBoxEventHandler);
        venisonCB.setOnAction(ingredientCheckBoxEventHandler);
        chickenCB.setOnAction(ingredientCheckBoxEventHandler);
        lambCB.setOnAction(ingredientCheckBoxEventHandler);
        fishCB.setOnAction(ingredientCheckBoxEventHandler);
        shrimpCB.setOnAction(ingredientCheckBoxEventHandler);
        crabCB.setOnAction(ingredientCheckBoxEventHandler);
        tofuCB.setOnAction(ingredientCheckBoxEventHandler);
        porkChopsCB.setOnAction(ingredientCheckBoxEventHandler);
        tempehCB.setOnAction(ingredientCheckBoxEventHandler);
        whiteRiceCB.setOnAction(ingredientCheckBoxEventHandler);
        brownRiceCB.setOnAction(ingredientCheckBoxEventHandler);
        farroCB.setOnAction(ingredientCheckBoxEventHandler);
        cuscusCB.setOnAction(ingredientCheckBoxEventHandler);
        freekehCB.setOnAction(ingredientCheckBoxEventHandler);
        polentaCB.setOnAction(ingredientCheckBoxEventHandler);
        blackBeansCB.setOnAction(ingredientCheckBoxEventHandler);
        garbanzoCB.setOnAction(ingredientCheckBoxEventHandler);
//        pastaCB.setOnAction(ingredientCheckBoxEventHandler);
//        tortillasCB.setOnAction(ingredientCheckBoxEventHandler);
//        cheeseCB.setOnAction(ingredientCheckBoxEventHandler);

    }

    public void getUserCuisineEntry() {
        // Get cuisine variable if user enters a cuisine
        if (!(comboBox.getValue() == null) || !(comboBox.getValue().trim().isEmpty())) {
            recipe.setCuisine(comboBox.getValue());
        }
    }

    public Boolean getGroundPorkSelection() {
        // Determine if ground pork checkbox is checked
        return groundPorkCB.isSelected();
    }

    @FXML
    public void setGroundPorkSelection() {
        if (getGroundPorkSelection()) {
            recipe.setmFood("ground pork");
        }
    }

    public String getRecipeNameFromCuisine(String cuisine) {
        return datasource.getRecipeNamesByCuisine(cuisine);
    }

    @FXML
    public void listViewRecipeSelection() {
        System.out.println("Clicked on " + recipeListView.getSelectionModel().getSelectedItem());
        String recipeName = recipeListView.getSelectionModel().getSelectedItem();
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equals(recipeName)) {
                imageView.setImage(recipe.getFile1());
                imageView2.setImage(recipe.getFile2());
                break;
            }
        }
    }

    // Set images for initial listView population
    public void selectFirstListViewEntry() {
        recipeListView.getSelectionModel().select(0);
        String recipeName = recipeListView.getSelectionModel().getSelectedItem();
        for (Recipe recipe : recipeList) {
            if (recipe.getName().equals(recipeName)) {
                imageView.setImage(recipe.getFile1());
                imageView2.setImage(recipe.getFile2());
                break;
            }
        }
    }

    // Create an observable list of recipe names
    public ObservableList<String> createRecipeNamesList(ObservableList<Recipe> recipeList) {
        ObservableList<String> recipeListNames = FXCollections.observableArrayList();
        for (Recipe recipe : recipeList) {
            recipeListNames.add(recipe.getName());
        }
        return recipeListNames;
    }

    /*
        Remove from current recipe list any recipe that does not have Ground Pork
        as a main food. These removed recipes will be added to a list called "removeRecipe List".
        Recipes from this list can be added back to the main recipe list if the Ground
        Pork checkbox becomes unchecked. If there are no Recipes in the main recipe list without
        Ground Pork as a main food, then nothing is performed.
         */
    public void addFoodToRemovedList(String mFood) {
        for (Recipe recipe : recipeList) {
            if (!(recipe.getmFood().equals(mFood))) {
                removedRecipeList.add(recipe);
            }
        }
        // Remove the Recipes from the recipeList that were added to removedList
        for(Recipe recipe : removedRecipeList) {
            recipeList.remove(recipe);
        }
        System.out.println("recipeList " + recipeList.toString());
        System.out.println("removedRecipeList " + removedRecipeList.toString());
        System.out.println("===================");
    }

    // If Recipe in the removeRecipe list has a main food that is not Main Food selection, add it back to recipeList
    public void addBackToRecipeList(String mFood) {
        for (Recipe recipe : removedRecipeList) {
            if (!(recipe.getmFood().equals(mFood))) {
                recipeList.add(recipe);
            }
        }
        // Remove the Recipes from the removedRecipeList that were added to recipeList
        Iterator<Recipe> it = removedRecipeList.iterator();
        while (it.hasNext()) {
            Recipe removeRecipe = it.next();
            if(!removeRecipe.getmFood().equals(mFood)) {
                it.remove();
            }
        }
        System.out.println("recipeList " + recipeList.toString());
        System.out.println("removedRecipeList " + removedRecipeList.toString());
        System.out.println("===================");
    }

    // Add Recipes with an ingredient of checkbox to ingredientRecipeList
    private void addIngredientRecipe(String checkBoxText) {
        for (Recipe recipe : recipeList) {
            if ((recipe.getmFood().equals(checkBoxText)) ||
                    (recipe.getsFood1().equals(checkBoxText)) ||
                    (recipe.getsFood2().equals(checkBoxText)) ||
                    (recipe.getsFood3().equals(checkBoxText))) {
                this.ingredientRecipeList.add(recipe);
            }
        }
        System.out.println("Ing List after addding = " + ingredientRecipeList.toString());
    }

    // Clear ingredientList of Recipes with unchecked ingredient checkbox
    private void removeIngredientRecipe(String checkBoxText) {
        this.ingredientRecipeList.removeIf(recipe -> (recipe.getmFood().equals(checkBoxText)) ||
                (recipe.getsFood1().equals(checkBoxText)) ||
                (recipe.getsFood2().equals(checkBoxText)) ||
                (recipe.getsFood3().equals(checkBoxText)));
        System.out.println("Ing List after removing = " + ingredientRecipeList.toString());
    }

}
