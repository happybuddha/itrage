package com.nav.arb.btcmarkets;

import java.io.IOException;
import java.math.BigDecimal;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.btcmarkets.BTCMarketsExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class BtcMarketsProvider {

	private MarketDataService marketDataService;
	
	public BtcMarketsProvider() {
	    // Use the factory to get Bitstamp exchange API using default settings
	    Exchange btcmarkets = ExchangeFactory.INSTANCE.createExchange(BTCMarketsExchange.class.getName());
	    // Interested in the public market data feed (no authentication)
	    this.marketDataService = btcmarkets.getMarketDataService();
	}

	public BigDecimal getBtcAsk() throws IOException {
		  Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_AUD);
		  System.out.println("BTC MARKETS : BTC_AUD : ASK " + ticker.getAsk());
		  return ticker.getAsk();
		  
	}
	
	public BigDecimal getBtcBid() throws IOException {
		  Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_AUD);
		  System.out.println("BTC MARKETS : BTC_AUD : BID " + ticker.getBid());
		  return ticker.getBid();
	}
	//ETH
	public BigDecimal getEthAsk () throws IOException {
		  Ticker ticker = marketDataService.getTicker(CurrencyPair.ETH_AUD);
		  System.out.println("BTC MARKETS : ETH_AUD : ASK" + ticker.getAsk());
		  return ticker.getAsk();
	}
	
	public BigDecimal getEthBid() throws IOException {
		  Ticker ticker = marketDataService.getTicker(CurrencyPair.ETH_AUD);
		  System.out.println("BTC MARKETS : ETH_AUD : BID " + ticker.getBid());
		  return ticker.getBid();
	}

	//End goal of this class will be to provide all interactions needed to arb with btcmarkets as one of the markets
	private static final String BTC_MARKETS_TICK_URL = "/market/BTC/AUD/tick";

}

