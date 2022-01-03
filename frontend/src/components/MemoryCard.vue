<template>
  <v-card outlined :to="idPath" :disabled="isDisabeled">

    <v-card-title>
        {{ title + "楼"}}
            <v-spacer></v-spacer>
        <p style="font-size:10px;color:gray">{{date}}</p>    
    </v-card-title>
    <v-card-subtitle>{{emoji}}</v-card-subtitle>
    <v-card-text style="white-space:pre-wrap">{{text}}</v-card-text>
  </v-card>
</template>

<script>
export default {
  props: { title: Number, emoji: String, text: String, date: String,hash:Number,isDisabeled:Boolean },
  data:()=>({
    idPath:""
  }),
  mounted(){
    this.idPath = "hole/" +this.title;
  }
};
</script>

<style>
#annotaion-font{
    font-size:"5px"
}
</style>
