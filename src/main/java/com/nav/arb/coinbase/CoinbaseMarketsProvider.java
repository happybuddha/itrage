package com.nav.arb.coinbase;

import java.io.IOException;
import java.math.BigDecimal;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinbase.CoinbaseExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class CoinbaseMarketsProvider {
	//End goal of this class will be to provide all interactions needed to arb with COINBASE as an exchange

	private MarketDataService marketDataService;
	
	public CoinbaseMarketsProvider() {
	    // Use the factory to get Bitstamp exchange API using default settings
	    Exchange coinbaseExchange = ExchangeFactory.INSTANCE.createExchange(CoinbaseExchange.class.getName());
	    // Interested in the public market data feed (no authentication)
	    this.marketDataService = coinbaseExchange.getMarketDataService();
	}

	public BigDecimal getBtcAsk() throws IOException {
		  Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_AUD);
		  System.out.println("COINBASE : BTC_AUD : ASK " + ticker.getAsk());
		  return ticker.getAsk();
		  
	}
	
	public BigDecimal getBtcBid() throws IOException {
		  Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_AUD);
		  System.out.println("COINBASE : BTC_AUD : BID " + ticker.getBid());
		  return ticker.getBid();
	}
	//ETH
	public BigDecimal getEthAsk () throws IOException {
		  Ticker tickerAskEthAud = marketDataService.getTicker(CurrencyPair.ETH_AUD);
		  System.out.println("COINBASE : ETH_AUD : ASK " + tickerAskEthAud.getAsk());
		  return tickerAskEthAud.getAsk();
	}
	
	public BigDecimal getEthBid() throws IOException {
		  Ticker tickerBidEthAud = marketDataService.getTicker(CurrencyPair.ETH_AUD);
		  System.out.println("COINBASE : ETH_AUD : BID " + tickerBidEthAud.getBid());
		  return tickerBidEthAud.getBid();
	}


}

