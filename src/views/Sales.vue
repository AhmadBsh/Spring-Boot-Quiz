<template>
<div class="backs fill-height">
    <v-container justify-center fluid fill-height>
      <v-row justify="center">
      <v-col cols="6" >
  <h1 class="text-center pb-2"> Welcome to Sales Management page  </h1>    
  <v-divider  ></v-divider>
  <v-card>
            <v-tabs
              color="deep-purple accent-4"
              background-color="primary"
              left
              v-model="tab3"
            >
              <v-tab class="white--text">Create New Sale</v-tab>
              <v-tab class="white--text">View Sales</v-tab>
              <v-tab class="white--text">Edit Sales</v-tab>
              <!-- <v-tab-items> -->
              <v-tab-item>
                <v-card class="mx-auto elevation-12  ">
                  <v-card-text >
                    <v-form
                      v-model="valid"
                      lazy-validation
                      ref="form"
                      class="py-10 px-7"
                    >
                  <h3>Let's sale something </h3>
                      <v-text-field
                        name="Sales"
                        label="Sale"
                        type="text"
                        counter="20"
                        v-model="sale.name"
                        :rules="salesRules"
                        required
                      ></v-text-field>
                      <v-textarea
                        label="Description"
                        rows="1"
                        type="text"
                        v-model="sale.description"
                        :rules="descriptionRules"
                        required
                      ></v-textarea>
                      <v-text-field
                        name="Category"
                        label="Category"
                        type="text"
                        counter="20"
                        v-model="sale.category"
                        :rules="categoryRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        name="QuantitiesInStock"
                        label="Quantities in Stock"
                        type="number"
                        v-model="sale.quantities"
                        :rules="quantitiesRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        name="PricePerPiece"
                        label="Price Per Piece"
                        type="number"
                        v-model="sale.price"
                        :rules="priceRules"
                        required
                      ></v-text-field>
                    </v-form>
                  </v-card-text>
                  <v-card-actions class="flex-column">
                    <v-spacer></v-spacer>
                    <v-btn 
                      :disabled="!valid"
                      class="mr-4 "
                      @click="validate ,editUserInfo"
                      color="primary"
                     >
                     Create
                     </v-btn>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <v-tab-item>
                <v-card class="mx-auto elevation-12 midcard Blured" >
                  <v-card-text class="pa-12" >
                    <v-form 
                    ref="reset"
                      class="pb-16 px-7"
                    >
                    <v-container class="cont " d-flex flex-column flex-direction: row >
                      <h3>Choose sale to view :</h3>
                      <v-select class="pr-16 pl-1 " 
                          :items="sales"
                          solo
                          label=""
                          ref="reset"
                          v-model="sale.name"
                          
                        ></v-select>
                        <p>sale id  {{sale.id.toString()}}</p>
                    </v-container >
                      <v-text-field
                        outlined
                        disabled
                        name="Sales"
                        label="Sale"
                        type="text"
                        v-model="sale.name"
                        
                      ></v-text-field>
                      <v-textarea
                        outlined
                        label="Description"
                        rows="1"
                        type="text"
                        v-model="sale.description"
                        disabled
                     ></v-textarea>
                      <v-text-field
                        outlined
                        disabled
                        name="Category"
                        label="Category"
                        type="text"
                        v-model="sale.category"
                        
                      ></v-text-field>
                      <v-text-field
                        outlined
                        disabled
                        name="QuantitiesInStock"
                        label="Quantities in Stock"
                        type="number"
                        v-model="sale.quantities"
                        
                      ></v-text-field>
                      <v-text-field
                        outlined
                        disabled
                        name="PricePerPiece"
                        label="Price Per Piece"
                        type="number"
                        v-model="sale.price"
                        
                        
                      ></v-text-field>
                    </v-form>
                    
                  </v-card-text>
                  <v-card-actions class="flex-column pt-0">
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <v-tab-item >
                <v-card class="mx-auto elevation-12 midcard Blured" >
                  <v-card-text class="pa-12" >
                    <v-form 
                    ref="reset"
                      class="pb-16 px-7"
                    >
                    <v-container class="cont " d-flex flex-column flex-direction: row >
                      <h3>Choose sale to edit :</h3>
                      <v-select class="pr-16 pl-1 "
                          :items="sales"
                          solo
                          label=""
                          ref="reset"
                          v-model="sale.name"
                          
                        ></v-select>
                    </v-container >
                      <v-text-field
                        name="Sales"
                        label="Sale"
                        type="text"
                        counter="20"
                        v-model="sale.name"
                        
                      ></v-text-field>
                      <v-textarea
                        label="Description"
                        rows="1"
                        type="text"
                        v-model="sale.description"
                     ></v-textarea>
                      <v-text-field
                        name="Category"
                        label="Category"
                        type="text"
                        counter="20"
                        v-model="sale.category"
                        
                      ></v-text-field>
                      <v-text-field
                        name="QuantitiesInStock"
                        label="Quantities in Stock"
                        type="number"
                        v-model="sale.quantities"
                        
                      ></v-text-field>
                      <v-text-field
                        name="PricePerPiece"
                        label="Price Per Piece"
                        type="number"
                        v-model="sale.price"
                        
                        
                      ></v-text-field>
                    </v-form>
                    <v-btn
                      color="success"
                      class="mr-4"
                      @click="editsaleInfo"
                    >
                      Edit
                    </v-btn>

                    <v-btn color="error" class="mr-4" @click="reset">
                      Cancel Edit
                    </v-btn>
                  </v-card-text>
                  <v-card-actions class="flex-column pt-0">
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <!-- </v-tab-items> -->
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
    tab3:null,
    items:[],
    disabled:true,
    sale: {
      id:[],

      name: ''
    },
    valid: false,
    Sales: [],
    salesRules: [
      (v) => !!v || "Sale is required",
      (v) => (v && v.length <= 20) || "Sale must be less than 20 characters",
    ],
    Description: "",
    descriptionRules: [
      (v) => !!v || "Description is required",
      (v) => (v && v.length <= 100) || "Description Must be less than 100 characters",
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
   mounted () {
    const self = this

    self.getsaleInfo()
  },
  methods: {
    validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.reset.reset();
    },
    reset2() {
      this.$refs.reset2.reset();
    },
    // editsaleInfo () {
    //   const self = this

    //   const info = {
    //     id: self.sale.id,
    //     name: self.sale.name,
    //     description: self.sale.description,
    //     category: self.sale.category,
    //     quantities: self.sale.quantities,
    //     price: self.sale.price,
    //     creation_date: self.sale.creation_date,
    //   }

    //   self.axios.post('', info).then((res) => {
        
    //   })
    // },
    // getsaleInfo () {
    //   const self = this

    //   self.axios.get('').then((res) => {
    //     self.sale = res.data
    //   })
    // }
  },
}
</script>

<style >

.cont {
  max-width: 300px !important;
}
.backs {
  background-image: url("~@/assets/Sales.jpg");
  background-size: cover;
  width: 100%;
}

</style>