<template>
<div class="backp fill-height">
    <v-container justify-center fluid fill-height>
      <v-row justify="center">
      <v-col cols="6" >
  <h1 class="text-center pb-2"> Welcome to Products Management page  </h1>    
  <v-divider  ></v-divider>
  <v-card>
            <v-tabs
              color="deep-purple accent-4"
              background-color="primary"
              left
            >
              <v-tab class="white--text">Create New Product</v-tab>
              <v-tab class="white--text">View/Update existing product</v-tab>
              <v-tab-item>
                <v-card class="mx-auto elevation-12 midcard Blured">
                  <v-card-text class="blured">
                    <v-form
                      v-model="valid"
                      lazy-validation
                      ref="form"
                      class="py-16 px-7"
                    >
                      <v-text-field
                        name="Productname"
                        label="Product Name"
                        type="text"
                        counter="20"
                        v-model="Productname"
                        :rules="productnameRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        name="Description"
                        label="Description"
                        type="text"
                        v-model="Description"
                        :rules="descriptionRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        name="Category"
                        label="Category"
                        type="text"
                        counter="20"
                        v-model="Category"
                        :rules="categoryRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        name="QuantitiesInStock"
                        label="Quantities in Stock"
                        type="number"
                        v-model="QuantitiesInStock"
                        :rules="quantitiesRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        name="PricePerPiece"
                        label="Price Per Piece"
                        type="number"
                        v-model="PricePerPiece"
                        :rules="priceRules"
                        required
                      ></v-text-field>
                    </v-form>
                  </v-card-text>
                  <v-card-actions class="flex-column">
                    <v-spacer></v-spacer>
                    <v-btn 
                      
                      :disabled="!valid"
                      class="mr-4 disabled"
                      @click="validate"
                      color="primary"
                     >
                     Login
                     </v-btn>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <v-tab-item>
                <v-card class="mx-auto elevation-12 midcard Blured">
                  <v-card-text class="pa-12">
                    <v-form ref="form" class=" py-2 pb-6">
                      <v-text-field
                        name="name"
                        label="Username"
                        type="text"
                        v-model="name"
                        :counter="20"
                        :rules="nameRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        name="email"
                        label="Email"
                        type="email"
                        required
                        v-model="email"
                        :rules="emailRules"
                      ></v-text-field>
                      <v-text-field class="pb-4"
                        name="password"
                        label="Password"
                        id="password"
                        type="password"
                        required
                        v-model="password"
                        :rules="passwordRules"
                      ></v-text-field>
                      <v-select
                        :items="specialization"
                        name="specialization"
                        label="Specialization"
                        dense
                        required v-model="select"
                        :rules="[(v) => !!v || 'Specialization is required']"
                      ></v-select>
                      <v-menu
                        ref="menu"
                        v-model="menu"
                        :close-on-content-click="false"
                        :return-value.sync="date"
                        transition="scale-transition"
                        offset-y
                        min-width="auto"
                      >
                        <template v-slot:activator="{ on, attrs }">
                          <v-text-field
                            v-model="date"
                            label="Choose your birthdate"
                            prepend-icon="mdi-calendar"
                            readonly
                            v-bind="attrs"
                            v-on="on"
                          ></v-text-field>
                        </template>
                        <v-date-picker v-model="date" no-title scrollable>
                          <v-spacer></v-spacer>
                          <v-btn text color="primary" @click="menu = false">
                            Cancel
                          </v-btn>
                          <v-btn
                            text
                            color="primary"
                            @click="$refs.menu.save(date)"
                          >
                            OK
                          </v-btn>
                        </v-date-picker>
                      </v-menu>
                      <v-spacer></v-spacer>
                      <v-menu
                        ref="menu2"
                        v-model="menu2"
                        :close-on-content-click="false"
                        :return-value.sync="date2"
                        transition="scale-transition"
                        offset-y
                        min-width="auto"
                      >
                        <template v-slot:activator="{ on, attrs }">
                          <v-text-field
                            v-model="date2"
                            label="Choose your registreation year"
                            prepend-icon="mdi-calendar"
                            readonly
                            v-bind="attrs"
                            v-on="on"
                          ></v-text-field>
                        </template>
                        <v-date-picker v-model="date2" no-title scrollable>
                          <v-spacer></v-spacer>
                          <v-btn text color="primary" @click="menu2 = false">
                            Cancel
                          </v-btn>
                          <v-btn
                            text
                            color="primary"
                            @click="$refs.menu2.save(date2)"
                          >
                            OK
                          </v-btn>
                        </v-date-picker>
                      </v-menu>
                      <v-checkbox
                        v-model="checkbox"
                        style="margin: 0px; max-height: 50px"
                        :rules="[(v) => !!v || 'You must agree to continue!']"
                        label="Do you agree?"
                        required
                      >
                        <template v-slot:label>
                          <div>I agree to terms and condition</div>
                        </template>
                      </v-checkbox>
                    </v-form>
                    <v-btn
                      :disabled="!valid"
                      color="success"
                      class="mr-4"
                      @click="validate"
                    >
                      Sign Up
                    </v-btn>

                    <v-btn color="error" class="mr-4" @click="reset">
                      Reset Form
                    </v-btn>
                  </v-card-text>
                  <v-card-actions class="flex-column pt-0">
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
            </v-tabs>
          </v-card>
      </v-col >
       </v-row>
       </v-container>
 
  </div>
</template>

<script>
export default {
  name: 'Home',
  components: {},

  data: () => ({
    valid: false,
    Productname: "",
    productnameRules: [
      (v) => !!v || "Product name is required",
      (v) => (v && v.length <= 20) || "Product name must be less than 20 characters",
    ],
    Description: "",
    descriptionRules: [
      (v) => !!v || "Description is required",
      
    ],
    Category: "",
    categoryRules: [
      (v) => !!v || "Category is required",
      (v) => (v && v.length <= 20) || "Category Must be less than 20 characters",
    ],
    QuantitiesInStock: "",
    quantitiesRules: [
      (v) => !!v || "Quantities is required",
      (v) => (v && v >= 0 && v <= 10000) || "Quantities Must be less than 10,000",

    ],
    PricePerPiece: "",
    priceRules: [
      (v) => !!v || "Price is required",
      (v) => (v && v >= 0 && v <= 10000) || "Price Must be less than 10,000",
    ],
  


  }),
methods: {
    validate() {
      this.$refs.form.validate();
    },
}
}
</script>

<style >

.backp {
  background-image: url("~@/assets/PMBackground.jpg");
  background-size: cover;
  width: 100%;
}

</style>
