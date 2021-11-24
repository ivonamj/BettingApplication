import http from "../http-common";

class BettingService {
    GetMatches(){
        return http.get("/matches");
    }

    AddBetslip(data) {
        return http.post("/matches", data);
    }

    GetBetslips(){
        return http.get("/betslip");
    }

    UpdateWallet() {
        return http.get("/wallet");
    }
}

export default new BettingService();