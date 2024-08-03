<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3>Add new Category</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-md-6 px-5 px-md-0">
                <form>
                    <div class="form-group">
                        <label>Category name</label>
                        <input type="text" class="form-control" v-model="categoryName" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" class="form-control" v-model="description" required>
                    </div>
                    <div class="form-group">
                        <label>ImageUrl</label>
                        <input type="url" class="form-control" v-model="imageUrl" required>
                    </div>
                    <button type="button" class="btn btn-primary" @click="addCategory">Submit</button>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import swal from 'sweetalert';

export default {
  data(){
    return{
        categoryName : '',
        description : '',
        imageUrl : '',
    }
  },
  methods:{
    async addCategory(){
        const newCategory = {
            categoryName: this.categoryName,
            description: this.description,
            imageUrl: this.imageUrl,
        };

        const baseUrl = "http://localhost:8080/";

        try {
            await axios.post(baseUrl + "category/create", newCategory, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            swal({
                text: "Category added successfully!",
                icon: "success",
                closeOnClickOutside: false,
            });
        } catch (error) {
            console.log(error);
        }
    }
  },
}
</script>

<style scoped>
    h3 {
        font-family: 'Roboto', sans-serif;
        color: #484848;
        font-weight: 700;
    }
</style>
