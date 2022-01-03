<template>
  <!-- 这里是具体的树洞页面的视觉层页面 -->
  <v-container>
    <div>
      <v-btn dark color="#7B1FA2" @click="backToHome">
        <v-icon>mdi-arrow-left</v-icon>
        返回前面
      </v-btn>

      <v-btn dark color="#7986CB" @click="gotoReply" style="float: right">
        立即回复
        <v-icon right>mdi-message-plus</v-icon>
      </v-btn>
    </div>

    <MemoryCard
      :date="mainInfo[0].date"
      :title="this.$route.params.id"
      :emoji="mainInfo[0].emojiInfo"
      :text="mainInfo[0].text"
      :isDisabeled="true"
    ></MemoryCard>

    <MailCard
      v-for="info in replyInfo"
      :key="info.text"
      :date="info.date"
      :text="info.text"
    ></MailCard>

    <v-row>
      <v-spacer> </v-spacer>
      <v-btn fab dark color="#9575CD" @click="replyShow">
        <v-icon>mdi-plus</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
    </v-row>

    <div id="replyBox" style="display: none">
      <v-card elevation="15">
        <v-card-title>
          <p style="color: #9575cd">回复</p>
        </v-card-title>
        <v-card-text>
          <v-textarea
            auto-grow
            color="#9575CD"
            outlined
            rows="8"
            label="温柔与善意是人间珍贵之物"
            id="replyText"
          ></v-textarea>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn outline color="#9575CD" dark @click="submitReply"
            >Submit</v-btn
          >
        </v-card-actions>
      </v-card>
    </div>

    <div id="successInfo" style="display: none">
      <AlertInfo
        text="提交成功！"
        :isDark="true"
        icon="mdi-checkbox-marked-circle-plus-outline"
        color="#66BB6A"
      ></AlertInfo>
    </div>
    <div id="errorInfo" style="display: none">
      <AlertInfo
        text="提交失败，可能是网络或者服务器宕机原因，建议您先保存待提交的内容后再刷新尝试。"
        :isDark="true"
        icon="mdi-alert-outline"
        color="#D32F2F"
      ></AlertInfo>
    </div>
    <div id="emptyInfo" style="display: none">
      <AlertInfo
        text="内容不得为空！"
        :isDark="true"
        icon="mdi-alert-outline"
        color="#D32F2F"
      ></AlertInfo>
    </div>
  </v-container>
</template>

<script>
import MailCard from "../components/MailCard.vue";
import MemoryCard from "../components/MemoryCard.vue";
import axios from "axios";
import AlertInfo from "../components/AlertInfo.vue";

export default {
  components: { MailCard, MemoryCard, AlertInfo },
  props: { emoji: String, date: String, text: String },
  data() {
    return {
      mainInfo: [
        {
          id: "404",
          date: "1906-01-01",
          emojiInfo: "😭",
          text: "当您看到这条信息的时候，说明我们的信息加载出现了些许问题。\n \n造成这一问题的原因可能是：\n1.若您是从搜索页面前往本页面的，那么可能是您输入了一个无效id或者该id对应的楼号不存在了。 \n 请注意，搜索只需要输入一个阿拉伯数字即可。\n2.您自身的网络状况存在问题。\n3.服务器发生了宕机。 \n\n请您先排查自身网络状况或者您的输入是否存在问题，如果无误的话可能是服务器宕机了（😭太穷了服务器带宽小得不知道说啥，在这里给您磕个头道歉了）。\n\n如果您时隔许久之后重新访问依然是这个界面，那么还请发邮件至\nleewendao@outlook.com\n与我们联系。",
        },
      ],
      replyInfo: [
        {
          id: "404",
          date: "1906-01-01",
          emojiInfo: "😭",
          text: "正在获取回复中，如果长时间无更改且上本出现404提示，则说明发生一些了问题。请按照上方的说明进行操作。",
        },
      ],
    };
  },
  beforeCreate() {
    axios
      .get(
        "http://mc.otterdaily.cn:2333/jz/MemoryHole/id=" + this.$route.params.id
      )
      .then((response) => {
        this.mainInfo = response.data;
      });

    axios
      .get(
        "http://mc.otterdaily.cn:2333/jz/MemoryMail/id=" + this.$route.params.id
      )
      .then((response) => {
        this.replyInfo = response.data;
      });
  },
  methods: {
    replyShow() {
      var boxDOM = document.getElementById("replyBox");
      if (boxDOM.style.display == "none") {
        boxDOM.removeAttribute("style");
      } else {
        boxDOM.setAttribute("style", "display:none");
      }
    },
    submitReply() {
      var theDate = new Date();
      if (document.getElementById("replyText").value != "") {
        axios
          .post(
            "http://mc.otterdaily.cn:2333/jz/MemoryMail/id=" +
              this.$route.params.id,
            {
              text: document.getElementById("replyText").value,
              date:
                theDate.getFullYear() +
                "-" +
                (theDate.getMonth() + 1) +
                "-" +
                theDate.getDate(),
              img: null,
            }
          )
          .then((response) => {
            if (response.status == 200) {
              this.successShow();
              setTimeout(location.reload(), 10000);
            } else {
              this.erroShow();
            }
          })
          .catch((error) => {
            if (error.request) {
              this.erroShow();
            } else {
              this.erroShow();
            }
          });
      } else {
        this.emptyAlert();
      }
    },
    successShow() {
      var boxDOM = document.getElementById("successInfo");
      if (boxDOM.style.display == "none") {
        boxDOM.removeAttribute("style");
      } else {
        boxDOM.setAttribute("style", "display:none");
      }
    },
    erroShow() {
      var boxDOM = document.getElementById("errorInfo");
      if (boxDOM.style.display == "none") {
        boxDOM.removeAttribute("style");
        document.querySelector("#errorInfo").scrollIntoView(true);   
      } else {
        boxDOM.setAttribute("style", "display:none");
      }
    },
    backToHome() {
      history.back(-1);
    },
    emptyAlert() {
      var boxDOM = document.getElementById("emptyInfo");
      if (boxDOM.style.display == "none") {
        boxDOM.removeAttribute("style");
        document.querySelector("#emptyInfo").scrollIntoView(true);   
      } else {
        boxDOM.setAttribute("style", "display:none");
      }
    },
    gotoReply(){
      this.replyShow();
      document.querySelector("#replyBox").scrollIntoView(true);    
    }
  },
};
</script>