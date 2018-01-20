package com.nav.arb.itrage;

import java.io.IOException;

import com.nav.arb.btcmarkets.BtcMarketsProvider;
import com.nav.arb.coinbase.CoinbaseMarketsProvider;

public class Arbitrage {
public static void main(String[] args) throws IOException{

	BtcMarketsProvider btcMarketsProvider = new BtcMarketsProvider();
	CoinbaseMarketsProvider coinbaseMarketsProvider = new CoinbaseMarketsProvider();
	
	//get ask and bid from btc markets
	btcMarketsProvider.getEthAsk(); //what the sellers want for one ETH
	btcMarketsProvider.getEthBid(); //what the buyers want to pay for one ETH
	
	coinbaseMarketsProvider.getEthAsk();
	coinbaseMarketsProvider.getEthBid();
	
	//The game is to buy from the lowest exchange and sell at the highest	
	//so, if I have one eth, I need to find the market with the highest bid for the eth
	
	//find cheapest eth
	//compareTo, x.compareTo(y). It will return 0 if x and y are equal, 1 if x is greater than y and -1 if x is smaller than y
	if(btcMarketsProvider.getEthAsk().compareTo(coinbaseMarketsProvider.getEthAsk()) >0 )
	{
		System.out.println("Cheap eth at Coinbase");
	}else
	{
		System.out.println("Cheap eth at btcmarkets");
	}

	//sell at highest bud
	if(btcMarketsProvider.getEthBid().compareTo(coinbaseMarketsProvider.getEthBid()) >0 )
	{
		System.out.println("Profitable to sell at BTCMARKETS");
	}else {
		System.out.println("Profitable to sell at COINBASE");
	}
		
}
}
