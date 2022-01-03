<template>
  <v-container>
    <template v-if="ifEmpty">
      <AlertInfo
        text="输入不得为空！"
        :isDark="true"
        icon="mdi-alert-outline"
        color="#D32F2F"
      ></AlertInfo>
    </template>

    <v-row>
      <v-col cols="10" sm="100"></v-col>

      <v-col cols="12" sm="200">
        <v-card elevation="99">
          <v-card-title style="color: #9575cd">创建一条回忆树洞</v-card-title>
          <v-card-text>
            输入一个Emoji：
            <v-text-field
              counter="2"
              maxlength="2"
              style="white-space: pre-wrap"
              solo
              label="或者两个描述性的字眼~"
              hint="Emoji用来描述这一楼的内容或其中寄予的感情。"
              id="emojiInfo"
            ></v-text-field>
          </v-card-text>
          <v-card-text style="white-space: pre-wrap">
            回忆内容：
            <v-textarea
              auto-grow
              color="#9575CD"
              solo
              rows="15"
              label="暖风、星空、梦想"
              id="replyText"
            ></v-textarea>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn outline color="#9575CD" dark fab @click="submitPeck">
              <v-icon>mdi-email-send-outline</v-icon>
            </v-btn>
            <v-spacer></v-spacer>
          </v-card-actions>
        </v-card>
      </v-col>
      <v-col cols="10" sm="100"></v-col>
    </v-row>
        <template v-if="ifSuccess">
      <AlertInfo
        text="提交成功！"
        :isDark="true"
        icon="mdi-checkbox-marked-circle-plus-outline"
        color="#66BB6A"
      ></AlertInfo>
    </template>
    <template v-if="ifError">
      <AlertInfo
        text="提交失败，可能是网络或者服务器宕机原因，建议您先保存待提交的内容后再刷新尝试。"
        :isDark="true"
        icon="mdi-alert-outline"
        color="#D32F2F"
      ></AlertInfo>
    </template>
  </v-container>
</template>

<script>
import axios from "axios";
import AlertInfo from "../components/AlertInfo.vue";

export default {
  components: { AlertInfo },
  data: () => ({
    emojiText: null,
    description: null,
    ifEmpty: false,
    ifSuccess: false,
    ifError: false,
  }),
  methods: {
    submitPeck() {
      if (document.getElementById("replyText").value != "" && document.getElementById("emojiInfo").value != "") {
        var theDate = new Date();
        axios
          .post("http://mc.otterdaily.cn:2333/jz/MemoryHole", {
            id: 233,
            emojiInfo: document.getElementById("emojiInfo").value,
            description: document.getElementById("replyText").value,
            date:
              theDate.getFullYear() +
              "-" +
              (theDate.getMonth() + 1) +
              "-" +
              theDate.getDate(),
          }).catch((error) => {
            if (error.request) {
              this.ifEmpty = false;
              this.erroShow();
            } else {
              this.ifEmpty = false;
              this.erroShow();
            }
          })
          .then((response) => {
            if (response.status == 200) {
              this.successShow();
              this.ifEmpty = false;
              this.ifError = false;
              console.log(response.data);
              this.$router.push({name:'Redirect',params:{id:response.data.id}})
            } else {
              this.erroShow();
            }
          });
      } else {
        this.emptyAlert();
      }
    },
    emptyAlert() {
      this.ifEmpty = !this.ifEmpty;
    },
    successShow() {
      this.ifSuccess = true;
    },
    erroShow() {
      this.ifError = true;
    },
  },
};
</script>