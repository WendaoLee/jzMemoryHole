<template>
  <v-container>
    <v-row>
      <v-spacer> </v-spacer>
      <v-btn fab dark color="#C62828" to="peckHole">
        <v-icon>mdi-plus-circle-outline</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
    </v-row>
    <v-row>
        
    </v-row>
    <!-- <v-row>
        <v-spacer></v-spacer>
        <v-breadcrumbs light :items="bread" divider="/"></v-breadcrumbs>
        <v-spacer></v-spacer>
    </v-row> -->

  </v-container>
</template>

<script>
export default {
  data: () => ({ 
    //   bread:[{disabled:false,text:"关于",href:"id"},
    //   {disabled:false,text:"查找树洞",href:"idPath"},
    //   {disabled:false,text:"反馈",href:"s"}]
   }),
};
</script>