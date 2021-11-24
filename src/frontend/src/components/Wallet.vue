<template>
  <div class = "container">
    {{wallet}}
  </div>
</template>

<script>
import BettingService from "@/services/BettingService";

export default {
  name: 'Wallet',
  data(){
    return {
      wallet: []
    }
  },
  methods: {
    UpdateWallet() {
      BettingService.UpdateWallet().then((response) => {
        this.wallet = response.data;
      });
    }
  },
  created() {
    this.UpdateWallet()
  }
}
</script>