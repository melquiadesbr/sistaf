package br.mil.eb.sistaf.util;

import java.util.HashMap;
import java.util.Map;

public class IndicesTaf {

	private static Map<String,int[]> mapaIndicesCorrida = new HashMap<String,int[]>();
	private static int[] arrayAux = new int[5];
	
	public static Map<String,int[]> getIndicesCorrida() {
		
		/** MASCULINO **/
		mapaIndicesCorrida.put("18M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("19M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("20M", configuraArray(2749,2849,3149,3249,3250));
		mapaIndicesCorrida.put("21M", configuraArray(2799,2899,3149,3249,3250));
		mapaIndicesCorrida.put("22M", configuraArray(2699,2849,3099,3249,3250));
		mapaIndicesCorrida.put("23M", configuraArray(2699,2849,3099,3199,3200));
		mapaIndicesCorrida.put("24M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("25M", configuraArray(2599,2749,3049,3199,3200));//TODO até aqui OK		
		mapaIndicesCorrida.put("26M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("27M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("28M", configuraArray(2749,2849,3149,3249,3250));
		mapaIndicesCorrida.put("29M", configuraArray(2799,2899,3149,3249,3250));
		mapaIndicesCorrida.put("30M", configuraArray(2699,2849,3099,3249,3250));
		mapaIndicesCorrida.put("31M", configuraArray(2699,2849,3099,3199,3200));
		mapaIndicesCorrida.put("32M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("33M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("34M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("35M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("36M", configuraArray(2749,2849,3149,3249,3250));
		mapaIndicesCorrida.put("37M", configuraArray(2799,2899,3149,3249,3250));
		mapaIndicesCorrida.put("38M", configuraArray(2699,2849,3099,3249,3250));
		mapaIndicesCorrida.put("39M", configuraArray(2699,2849,3099,3199,3200));
		mapaIndicesCorrida.put("40M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("41M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("42M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("43M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("44M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("45M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("46M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("47M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("48M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("49M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("50M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("51M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("52M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("53M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("54M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("55M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("56M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("57M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("58M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("59M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("60M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("61M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("62M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("63M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("64M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("65M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("18M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("19M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("20M", configuraArray(2749,2849,3149,3249,3250));
		mapaIndicesCorrida.put("21M", configuraArray(2799,2899,3149,3249,3250));
		mapaIndicesCorrida.put("22M", configuraArray(2699,2849,3099,3249,3250));
		mapaIndicesCorrida.put("23M", configuraArray(2699,2849,3099,3199,3200));
		mapaIndicesCorrida.put("24M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("25M", configuraArray(2599,2749,3049,3199,3200));
		
		/** FEMININO **/
		mapaIndicesCorrida.put("18F", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("19F", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("20F", configuraArray(2749,2849,3149,3249,3250));
		mapaIndicesCorrida.put("21F", configuraArray(2799,2899,3149,3249,3250));
		mapaIndicesCorrida.put("22F", configuraArray(2699,2849,3099,3249,3250));
		mapaIndicesCorrida.put("23F", configuraArray(2699,2849,3099,3199,3200));
		mapaIndicesCorrida.put("24F", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("25F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("26F", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("27F", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("28F", configuraArray(2749,2849,3149,3249,3250));
		mapaIndicesCorrida.put("29F", configuraArray(2799,2899,3149,3249,3250));
		mapaIndicesCorrida.put("30F", configuraArray(2699,2849,3099,3249,3250));
		mapaIndicesCorrida.put("31F", configuraArray(2699,2849,3099,3199,3200));
		mapaIndicesCorrida.put("32F", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("33F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("34F", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("35F", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("36F", configuraArray(2749,2849,3149,3249,3250));
		mapaIndicesCorrida.put("37F", configuraArray(2799,2899,3149,3249,3250));
		mapaIndicesCorrida.put("38F", configuraArray(2699,2849,3099,3249,3250));
		mapaIndicesCorrida.put("39F", configuraArray(2699,2849,3099,3199,3200));
		mapaIndicesCorrida.put("40F", configuraArray(2699,2799,3099,3199,3200));
		mapaIndicesCorrida.put("41F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("42F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("43F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("44F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("45F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("46F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("47F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("48F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("49F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("50F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("51F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("52F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("53F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("54F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("55F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("56F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("57F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("58F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("59F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("60F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("61F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("62F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("63F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("64F", configuraArray(2599,2749,3049,3199,3200));
		mapaIndicesCorrida.put("65F", configuraArray(2599,2749,3049,3199,3200));
	
		return mapaIndicesCorrida;
	}
	
	private static int[] configuraArray(int i1, int i2, int i3, int i4, int i5){
		
		arrayAux[0] = i1;
		arrayAux[1] = i2;
		arrayAux[2] = i3;
		arrayAux[3] = i4;
		arrayAux[4] = i5;
		
		return arrayAux;
	}
	
}
