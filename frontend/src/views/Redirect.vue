<template>
  <v-container>
    <AlertInfo
      :text="text"
      :isDark="true"
      icon="mdi-checkbox-marked-circle-plus-outline"
      color="#66BB6A"
    ></AlertInfo>
    <v-card>
      <v-card-title>什么是树洞编号？</v-card-title>
      <v-card-subtitle>What?</v-card-subtitle>

      <v-card-text style="white-space: pre-wrap"> {{ info }}</v-card-text>
    </v-card>
    <v-row>
      <v-spacer> </v-spacer>
      <v-btn fab dark color="#009688" @click="flyTo">
        <v-icon>mdi-send</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
    </v-row>
  </v-container>
</template>

<script>
import AlertInfo from "../components/AlertInfo.vue";
export default {
  components: { AlertInfo },
  data: () => {
    return {
      text: "提交成功！您的树洞编号（即楼号）为" + this.$route.params.id,
      info: "",
      id:null,
    };
  },
  beforeCreate() {
    this.text =
      ' 提交成功！\n 您的树洞编号（即楼号）为 "' +
      this.$route.params.id +
      '"\n\n您可以通过点击下方纸飞机按钮前往树洞具体页面。';
    this.info =
      "受限于服务器带宽与配置问题，我们不会在首页渲染所有人提交的回忆信息。\n \n为了让每条回忆都可以被访问，我们必须给这条记忆加上一个编号，这也便是我们的树洞编号。 \n \n 通过树洞编号，您可以通过我们的搜索界面直接前往改树洞查看它的详细信息与下方的回复帖。 \n\n 同样，您可以记住您的楼号编号并把它分享给你的朋友们，他们可以通过搜索入口直接前往。";
      this.id = this.$route.params.id;
  },
  methods: {
    flyTo() {
      this.$router.push({ name:'Hole',params:{id:this.id} });
    },
  },
};
</script>