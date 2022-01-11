<template>
  <div id="top">
    <div style="width: 100%; height: 140px; background-color: #424242">
      <br />
      <v-row
        ><v-spacer></v-spacer
        ><v-avatar
          ><v-icon class="center" dark
            >mdi-information-outline</v-icon
          ></v-avatar
        >
        <v-spacer></v-spacer
      ></v-row>
      <br />
      <p class="center">关于</p>
      <p class="center" style="font-size: 20px">About</p>
    </div>
    <div>
      <v-card width="100%" height="1000px">
        <v-card-title
          >写 在 前 面 <v-spacer></v-spacer>
          <v-icon>mdi-send</v-icon></v-card-title
        >

        <v-card-subtitle style="font-size: 13px"
          >缙中路18号树洞</v-card-subtitle
        >
        <v-divider></v-divider>
        <v-card-text
          >缙中路18号树洞，起源于<u>缙中路18号回忆录</u>这个文档。</v-card-text
        >
        <v-card-text
          >缙中路18号回忆录是浙江省缙云中学20届毕业生于2021年12月23号创建的腾讯在线共享文档，该文档用于让各届缙云中学毕业生记录自己在缙云中学所度过的那些特殊而温暖、普通且珍贵的日子，从而以文字的形式保留下不同缙中学子在缙中求学的高中三年记忆。</v-card-text
        >
        <v-card-text
          >不过可惜的是，由于同时编辑的人过多，加上恶意篡改、删除等情况的发生，导致文档原有内容大量流失，不得已之下文档创建者关闭了文档。</v-card-text
        >
        <v-card-text
          >这是一大遗憾。过去的平凡日子正是因为我们的珍贵回忆而变得独一无二，而人的记忆会随时间的流逝而不断消磁。如果原本有这么一个地方可以记录下我们那些温暖而温柔的回忆但最终消失了，这绝对是一种份量不轻的损失。</v-card-text
        >
        <v-card-text
          >故而我们在此启动了<b>“缙中路18号树洞”</b>的项目。您可以在这里，通过古早的网站留言板的形式来留下你对于缙云中学的各种人事物的珍贵记忆，而其他人亦可以看到这些回忆像文档里的那般做出回复。</v-card-text
        >
        <v-card-text
          >我们会定期提供公开的数据下载渠道分享这些宝贵的记忆数据，并保证网站的非盈利化与纯净化。在网站计划的运营周期完结时，我们会提供可靠的、公开的数据获取渠道供任何缙中学子保存。欢迎大家监督或提出您的宝贵建议。</v-card-text
        >
        <v-card-text
          >网站的相关源码（包括前后端）我们会在不久后公开至Github，欢迎有兴趣与能力的朋友参与到我们网站的运营与维护中。</v-card-text
        >
        <v-card-text
          ><p style="text-align: right">
            <b>以上</b><br /><b>建站者</b><br />2021-12-28
          </p></v-card-text
        >
      </v-card>
      <v-divider></v-divider>
      <v-card width="100%" height="430px" elevation="50">
        <v-card-title
          >基 本 信 息 <v-spacer></v-spacer>
          <v-icon>mdi-tree-outline</v-icon></v-card-title
        >
        <v-card-subtitle style="font-size: 13px"
          >关于整个项目的计划与网站基本信息</v-card-subtitle
        >
        <v-divider></v-divider>
        <v-card-text>
          <b>计划开发周期：2021.12.28 - 2023.1.14</b>
          <br />
          <b>计划运营周期：2021.12.28 - 2023.12.28</b>
          <br />
          <br />
          计划开发周期是指整个项目的计划开发（包括网站更新、开发项目的新内容例如小程序）的时间段，计划开发周期结束后基本上项目不会有功能的更新。
          <br />
          <br />
          计划运营周期是指网站的日常维护与运营的时间段。在计划运营周期结束后，网站将会关闭。
          <br>
          <br>
          网站域名：jz.otterdaily.cn
          <br>
          服务器带宽：5M
          <br>
          技术栈：Vue+Vuetify+axios+Spring Boot+Mysql
          <br>
          隐私政策与数据使用协议：<a href="privacy.html">点击此处</a>

        </v-card-text>
      </v-card>
      <v-divider></v-divider>
      <v-card width="100%" height="180px" elevation="50">
        <v-card-title
          >开 发 者 <v-spacer></v-spacer>
          <v-icon>mdi-github</v-icon></v-card-title
        >
        <v-card-subtitle style="font-size: 13px">Developer</v-card-subtitle>
        <v-divider></v-divider>
        <br />
        <v-row no-gutters>
          <v-col cols="1"></v-col>
          <v-col cols="2">
            <v-avatar><v-img src="wendaolee.jpg"></v-img></v-avatar>
          </v-col>
          <v-col>
            <br />
            <v-row>
              <p style="color: #757575; font-size: 14px">李 问 道</p>
            </v-row>
            <v-row>
              <p style="color: #757575; font-size: 11px">
                leewendao@outlook.com
              </p>
            </v-row>
            <v-row>
              <p style="color: #757575; font-size: 11px">
                缙云中学20届毕业生。普通人。
              </p>
            </v-row>
          </v-col>
        </v-row>
        <br />
      </v-card>
      <v-divider></v-divider>
      <v-card width="100%" height="180px" elevation="50">
        <v-card-title
          >维 护 者 <v-spacer></v-spacer>
          <v-icon>mdi-account</v-icon></v-card-title
        >
        <v-card-subtitle style="font-size: 13px">Webmaster</v-card-subtitle>
        <v-divider></v-divider>
        <br />
        <v-row no-gutters>
          <v-col cols="1"></v-col>
          <v-col cols="2">
            <v-avatar><v-img src="wendaolee.jpg"></v-img></v-avatar>
          </v-col>
          <v-col>
            <br />
            <v-row>
              <p style="color: #757575; font-size: 14px">李 问 道</p>
            </v-row>
            <v-row>
              <p style="color: #757575; font-size: 11px">
                leewendao@outlook.com
              </p>
            </v-row>
            <v-row>
              <p style="color: #757575; font-size: 11px">
                缙云中学20届毕业生。普通人。
              </p>
            </v-row>
          </v-col>
        </v-row>
        <br />
      </v-card>
      <v-card width="100%" height="300px" elevation="50">
        <v-card-title
          >更 多<v-spacer></v-spacer>
          <v-icon>mdi-dots-horizontal-circle-outline</v-icon></v-card-title
        >
        <v-card-subtitle style="font-size: 13px">More</v-card-subtitle>

        <br>
        <v-row>
          <v-spacer></v-spacer>
          <v-btn fab outlined color="#FAFAFA" href="https://github.com/WendaoLee/jzMemoryHole">
          <v-avatar size="50"><v-icon size="50" color="#212121">mdi-github</v-icon></v-avatar>
          </v-btn>
          <v-spacer></v-spacer>
        </v-row>
        <v-row>
          <v-spacer></v-spacer>
           <p style="font-size: 13px;color:#212121">Github</p>
          <v-spacer></v-spacer>
        </v-row>
      </v-card>
    </div>
  </div>
</template>

<script>
export default {
  mounted(){
    document.querySelector("#top").scrollIntoView(true);
  }
}
</script>

<style>
.center {
  text-align: center;
  line-height: 30px;
  font-size: 25px;
  color: white;
}
</style>
