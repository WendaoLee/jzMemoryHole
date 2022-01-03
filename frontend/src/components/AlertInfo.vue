<template>
  <v-alert :type="type" :color="color" :icon="icon" :dark="isDark"  dismissible >
   <p style="color:white;font-size:14px">{{ text }} </p>
  </v-alert>
</template>

<script>
export default {
  props: { type: String, text: String, color: String, icon: String ,isDark:Boolean},
};
</script>