<template>
  <v-container>
    <AlertInfo
      text="这里是缙中路18号树洞的索引页。索引页目前包含了树洞储存的所有记忆信息。
      
请注意：目前的索引页是动态页，它的每一次访问都会带来高额的成本开销。故而索引页的目的只是供在缙中路18号回忆录的文档里建过楼的朋友查看自己所在楼的编号，如果愿意继续聊下去则可以把编号分享给好友后通过搜索页面前往该楼聊天。

当然，索引页预计在将来会成为静态页。不过目前而言我们非常不建议您频繁访问该页面。"
      color="#FF7043"
      icon="mdi-alert-circle-outline"
      :isDark="true"
    ></AlertInfo>

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
import MemoryCard from "./MemoryCard.vue";
import axios from "axios";
import AlertInfo from "./AlertInfo.vue";
import BottomNavi from "./BottomNavi.vue";

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
      .get("http://mc.otterdaily.cn:2333/jz/MemoryHole/all")
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
  },
};
</script>
