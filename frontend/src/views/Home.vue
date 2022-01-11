<template>
    <v-container>
    <AlertInfo
      text="这里是缙中路18号树洞，它是对缙中路18号回忆录共享文档的延续。欢迎广大缙中学子在此留下自己的高中美好回忆。

第一次使用务必点击下方公告楼查看相关使用说明。更多信息可见[关于]页。

安卓用户通过微信内置浏览器进行回帖或建楼操作时可能会发生页面疯狂闪烁的问题，我们建议您复制本站地址至浏览器访问。"
      color="#FF7043"
      icon="mdi-alert-circle-outline"
      :isDark="true"
    ></AlertInfo>
    <v-card to="hole/0" color="">
      <v-card-title>
        公告楼
        <v-spacer></v-spacer>
        <p style="font-size: 10px; color: gray">
          <b>入站必看</b>|长期置顶|上一次更新2021-12-30
        </p>
      </v-card-title>
      <v-card-subtitle>点击进入</v-card-subtitle>
      <v-card-text>内含树洞相关使用说明、旧文档数据迁移问题的相关说明。<b>入站必看。</b><br><br>为节省服务器带宽与资源开销，首页只显示最新20楼。全部回忆内容请见<b>[索引]</b>，新建回忆请下滑至底部点击加号，查找对应楼请点击<b>[搜索]</b>。<br>
      </v-card-text>
    </v-card>
    <br />
    <v-row>
      <v-spacer></v-spacer>
      <v-col>
        <v-chip label dark color="#26A69A" @click="gotoSearch">
          <v-icon left dark>mdi-file-find-outline</v-icon>
          搜索</v-chip
        >
      </v-col>
      <v-col>
        <v-chip label dark color="#5C6BC0" @click="gotoIndex">
          <v-icon left dark>mdi-book-multiple-outline</v-icon>
          索引</v-chip
        >
      </v-col>
      <v-col>
        <v-chip label dark color="#78909C" @click="gotoAbout">
          <v-icon left dark>mdi-information-outline</v-icon>
          关于</v-chip
        >
      </v-col>
      <v-spacer></v-spacer>
    </v-row>
    <br />
    <MemoryCard
      v-for="info in indexInfo"
      :key="info.id"
      :title="info.id"
      :date="info.date"
      :emoji="info.emojiInfo"
      :text="info.text"
      :hash="info.hash"
    ></MemoryCard>

    <BottomNavi></BottomNavi>
  </v-container>
</template>

<script>
import MemoryCard from "../components/MemoryCard.vue";
import axios from "axios";
import AlertInfo from "../components/AlertInfo.vue";
import BottomNavi from "../components/BottomNavi.vue";

export default {
  components: { MemoryCard, AlertInfo, BottomNavi },
  name: "HelloWorld",

  data: () => ({
    indexInfo: [
      {
        id: "404",
        date: "1970-01-01",
        emojiInfo: "😭",
        text: "当您看到这条信息的时候，说明我们的信息加载出现了些许问题。 \n造成这一问题的原因可能是您自身网络或者我们的服务器发生了宕机。请您先排查自身网络状况，如果无误的话可能是服务器宕机了（😭太穷了服务器带宽小得不知道说啥，在这里给您磕个头道歉了）。\n如果您时隔许久之后重新访问依然是这个界面，那么还请发邮件至\n leewendao@out.com \n与我们联系",
      },
    ],
  }),
  beforeCreate() {
    axios
      .get("http://mc.otterdaily.cn:2333/jz/MemoryHole/latest")
      .then((response) => {
        console.log(response.data[0]);
        this.indexInfo = response.data;
        console.log(this.indexInfo);
      });
  },
  methods: {
    naviTo: function () {
      this.$router.push();
    },
    test: function () {
      alert("233");
    },
    gotoAbout() {
      this.$router.push({ name: "About" });
    },
    gotoSearch() {
      this.$router.push({ name: "Search" });
    },
    gotoIndex(){
      this.$router.push({ name: "Index" });
    }
  },
};
</script>

