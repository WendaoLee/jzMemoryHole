<template>
  <v-card color="#F3E5F5">
    <v-card-title>
      Re:
      <v-spacer></v-spacer>
      <p style="font-size: 10px; color: gray">{{ date }}</p>
    </v-card-title>
    <v-card-text style="white-space:pre-wrap">{{ text }}</v-card-text>
  </v-card>
</template>

<script>


export default {
  props: { date: String, text: String }
};
</script>