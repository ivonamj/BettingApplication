<template>
  <div class = "container">
    <table class="table table-striped">
      <tbody v-for = "betslip in betslips" v-bind:key = "betslip.id">
        <tr v-for = "match in betslip.matchesOnBetslip" v-bind:key = "match.id">
          <td> {{match.name}} </td>
          <td> {{match.homeAwayDraw}} </td>
          <td> {{match.odd}} </td>
        </tr>
        <tr style="text-align:right">
          <b> Odds: {{betslip.odds}}
            Payment: {{betslip.payment}}
            Possible gain: {{betslip.possibleGain}}</b>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import BettingService from "@/services/BettingService";

export default {
  name: 'Betslips',
  data(){
    return {
      betslips: []
    }
  },
  methods: {
    GetBetslips() {
      BettingService.GetBetslips().then((response) => {
        this.betslips = response.data;
      });
    }
  },
  created() {
    this.GetBetslips()
  }
}
</script>