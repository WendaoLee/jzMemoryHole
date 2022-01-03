<template>
    <v-container>
        <v-card>
            <v-card-title><v-spacer></v-spacer> 前 往 树 洞 <v-spacer></v-spacer></v-card-title>
            <v-card-subtitle style="text-align:center">输入数字编号前往 <br> 例如输入0可到达公告楼</v-card-subtitle>
            <br>
            <v-row>
                <v-spacer></v-spacer>
            <v-text-field outlined id="inputId"></v-text-field>
            <v-spacer></v-spacer>
            </v-row>
        </v-card>
            <v-row>
      <v-spacer> </v-spacer>
      <v-btn fab dark color="#66BB6A" @click="flyTo">
        <v-icon>mdi-send</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
    </v-row>
    </v-container>
</template>

<script>
export default {
    methods:{
        flyTo(){
            this.$router.push({ name:'Hole',params:{id:document.getElementById("inputId").value} });
            
        }
    }
}
</script>