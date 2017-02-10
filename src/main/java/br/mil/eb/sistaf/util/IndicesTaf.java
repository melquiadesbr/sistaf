package br.mil.eb.sistaf.util;

import java.util.HashMap;
import java.util.Map;

public class IndicesTaf {

	private static Map<String,int[]> mapaIndices = new HashMap<String,int[]>();
	
	public static Map<String,int[]> getIndices() {
		
		/** MASCULINO **/
		mapaIndices.put("C18M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndices.put("C19M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndices.put("C20M", configuraArray(2749,2849,3149,3249,3250));
		mapaIndices.put("C21M", configuraArray(2799,2899,3149,3249,3250));
		mapaIndices.put("C22M", configuraArray(2699,2849,3099,3249,3250));
		mapaIndices.put("C23M", configuraArray(2699,2849,3099,3199,3200));
		mapaIndices.put("C24M", configuraArray(2699,2799,3099,3199,3200));
		mapaIndices.put("C25M", configuraArray(2599,2749,3049,3199,3200));
		mapaIndices.put("C26M", configuraArray(2599,2749,3049,3149,2150));
		mapaIndices.put("C27M", configuraArray(2599,2749,3049,3149,3150));
		mapaIndices.put("C28M", configuraArray(2549,2699,2999,3149,3150));
		mapaIndices.put("C29M", configuraArray(2549,2699,2949,2950,3100));
		mapaIndices.put("C30M", configuraArray(2499,2649,2949,3099,3100));
		mapaIndices.put("C31M", configuraArray(2499,2649,2949,3099,3100));
		mapaIndices.put("C32M", configuraArray(2499,2649,2650,3049,3050));
		mapaIndices.put("C33M", configuraArray(2499,2649,2899,3049,3050));
		mapaIndices.put("C34M", configuraArray(2349,2549,2849,2999,3000));
		mapaIndices.put("C35M", configuraArray(2299,2499,2799,2949,2950));
		mapaIndices.put("C36M", configuraArray(2299,2499,2799,2949,2950));
		mapaIndices.put("C37M", configuraArray(2299,2499,2799,2949,2950));
		mapaIndices.put("C38M", configuraArray(2249,2449,2749,2899,2900));
		mapaIndices.put("C39M", configuraArray(2249,2449,2749,2899,2900));
		mapaIndices.put("C40M", configuraArray(2249,2449,2749,2899,2900));
		mapaIndices.put("C41M", configuraArray(2199,2399,2699,2849,2850));
		mapaIndices.put("C42M", configuraArray(2199,2399,2699,2849,2850));
		mapaIndices.put("C43M", configuraArray(2149,2349,2649,2799,2800));
		mapaIndices.put("C44M", configuraArray(2149,2349,2649,2799,2800));
		mapaIndices.put("C45M", configuraArray(2099,2299,2599,2749,2750));
		mapaIndices.put("C46M", configuraArray(2099,2299,2599,2749,2750));
		mapaIndices.put("C47M", configuraArray(2049,2249,2549,2699,2700));
		mapaIndices.put("C48M", configuraArray(2049,2199,2499,2649,2650));
		mapaIndices.put("C49M", configuraArray(1999,2149,2449,2599,2600));
		mapaIndices.put("C50M", configuraArray(1950,0,0,0,0));
		mapaIndices.put("C51M", configuraArray(1950,0,0,0,0));
		mapaIndices.put("C52M", configuraArray(1900,0,0,0,0));
		mapaIndices.put("C53M", configuraArray(1900,0,0,0,0));
		mapaIndices.put("C54M", configuraArray(1850,0,0,0,0));
		mapaIndices.put("C55M", configuraArray(1850,0,0,0,0));
		mapaIndices.put("C56M", configuraArray(1800,0,0,0,0));
		mapaIndices.put("C57M", configuraArray(1800,0,0,0,0));
		mapaIndices.put("C58M", configuraArray(1750,0,0,0,0));
		mapaIndices.put("C59M", configuraArray(1700,0,0,0,0));
		mapaIndices.put("C60M", configuraArray(1650,0,0,0,0));
		mapaIndices.put("C61M", configuraArray(1600,0,0,0,0));
		mapaIndices.put("C62M", configuraArray(1550,0,0,0,0));
		mapaIndices.put("C63M", configuraArray(1500,0,0,0,0));
		mapaIndices.put("C64M", configuraArray(1450,0,0,0,0));
		mapaIndices.put("C65M", configuraArray(1400,0,0,0,0));
		
		mapaIndices.put("F18M", configuraArray(20,25,34,38,39));
		mapaIndices.put("F19M", configuraArray(20,25,34,38,39));
		mapaIndices.put("F20M", configuraArray(22,27,36,40,41));
		mapaIndices.put("F21M", configuraArray(26,29,37,40,41));
		mapaIndices.put("F22M", configuraArray(24,27,36,40,41));
		mapaIndices.put("F23M", configuraArray(24,27,35,39,40));
		mapaIndices.put("F24M", configuraArray(23,27,34,38,39));
		mapaIndices.put("F25M", configuraArray(23,26,34,37,38));
		mapaIndices.put("F26M", configuraArray(23,26,34,37,38));
		mapaIndices.put("F27M", configuraArray(22,26,34,37,38));
		mapaIndices.put("F28M", configuraArray(22,26,33,37,38));
		mapaIndices.put("F29M", configuraArray(22,26,33,36,37));
		mapaIndices.put("F30M", configuraArray(22,25,32,36,37));
		mapaIndices.put("F31M", configuraArray(21,24,32,36,37));
		mapaIndices.put("F32M", configuraArray(21,24,32,36,37));
		mapaIndices.put("F33M", configuraArray(21,23,32,35,36));
		mapaIndices.put("F34M", configuraArray(18,21,29,33,34));
		mapaIndices.put("F35M", configuraArray(18,21,28,32,33));
		mapaIndices.put("F36M", configuraArray(18,21,28,32,33));
		mapaIndices.put("F37M", configuraArray(17,20,28,32,33));
		mapaIndices.put("F38M", configuraArray(17,20,27,31,32));
		mapaIndices.put("F39M", configuraArray(17,20,27,31,32));
		mapaIndices.put("F40M", configuraArray(16,19,27,31,32));
		mapaIndices.put("F41M", configuraArray(16,19,26,30,31));
		mapaIndices.put("F42M", configuraArray(16,19,26,30,31));
		mapaIndices.put("F43M", configuraArray(16,19,26,29,30));
		mapaIndices.put("F44M", configuraArray(16,19,26,29,30));
		mapaIndices.put("F45M", configuraArray(15,17,25,28,29));
		mapaIndices.put("F46M", configuraArray(15,17,24,27,28));
		mapaIndices.put("F47M", configuraArray(14,17,23,26,27));
		mapaIndices.put("F48M", configuraArray(14,16,22,25,26));
		mapaIndices.put("F49M", configuraArray(14,16,22,24,25));
		mapaIndices.put("F50M", configuraArray(14,0,0,0,0));
		mapaIndices.put("F51M", configuraArray(14,0,0,0,0));
		mapaIndices.put("F52M", configuraArray(14,0,0,0,0));
		mapaIndices.put("F53M", configuraArray(13,0,0,0,0));
		mapaIndices.put("F54M", configuraArray(13,0,0,0,0));
		mapaIndices.put("F55M", configuraArray(13,0,0,0,0));
		mapaIndices.put("F56M", configuraArray(12,0,0,0,0));
		mapaIndices.put("F57M", configuraArray(12,0,0,0,0));
		mapaIndices.put("F58M", configuraArray(11,0,0,0,0));
		mapaIndices.put("F59M", configuraArray(11,0,0,0,0));
		mapaIndices.put("F60M", configuraArray(10,0,0,0,0));
		mapaIndices.put("F61M", configuraArray(10,0,0,0,0));
		mapaIndices.put("F62M", configuraArray(9,0,0,0,0));
		mapaIndices.put("F63M", configuraArray(9,0,0,0,0));
		mapaIndices.put("F64M", configuraArray(8,0,0,0,0));
		mapaIndices.put("F65M", configuraArray(8,0,0,0,0));
		
		mapaIndices.put("B18M", configuraArray(4,6,9,11,12));
		mapaIndices.put("B19M", configuraArray(4,6,9,11,12));
		mapaIndices.put("B20M", configuraArray(4,7,10,11,12));
		mapaIndices.put("B21M", configuraArray(5,7,10,12,13));
		mapaIndices.put("B22M", configuraArray(4,7,10,11,12));
		mapaIndices.put("B23M", configuraArray(4,7,10,11,12));
		mapaIndices.put("B24M", configuraArray(4,7,10,11,12));
		mapaIndices.put("B25M", configuraArray(4,7,10,11,12));
		mapaIndices.put("B26M", configuraArray(4,6,9,11,12));
		mapaIndices.put("B27M", configuraArray(4,6,9,10,11));
		mapaIndices.put("B28M", configuraArray(4,6,9,10,11));
		mapaIndices.put("B29M", configuraArray(3,6,8,10,11));
		mapaIndices.put("B30M", configuraArray(3,5,8,10,11));
		mapaIndices.put("B31M", configuraArray(3,5,8,10,11));
		mapaIndices.put("B32M", configuraArray(3,5,8,10,11));
		mapaIndices.put("B33M", configuraArray(3,5,8,9,10));
		mapaIndices.put("B34M", configuraArray(2,4,7,8,9));
		mapaIndices.put("B35M", configuraArray(1,3,7,8,9));
		mapaIndices.put("B36M", configuraArray(1,3,6,7,8));
		mapaIndices.put("B37M", configuraArray(1,3,6,7,8));
		mapaIndices.put("B38M", configuraArray(1,3,6,7,8));
		mapaIndices.put("B39M", configuraArray(1,2,5,6,7));
		
		mapaIndices.put("A18M", configuraArray(34,44,63,73,74));
		mapaIndices.put("A19M", configuraArray(34,44,63,73,74));
		mapaIndices.put("A20M", configuraArray(37,48,68,78,79));
		mapaIndices.put("A21M", configuraArray(39,48,66,75,76));
		mapaIndices.put("A22M", configuraArray(40,48,66,75,76));
		mapaIndices.put("A23M", configuraArray(39,47,66,75,76));
		mapaIndices.put("A24M", configuraArray(39,47,66,75,76));
		mapaIndices.put("A25M", configuraArray(39,47,65,73,74));
		mapaIndices.put("A26M", configuraArray(37,46,65,73,74));
		mapaIndices.put("A27M", configuraArray(37,46,64,71,72));
		mapaIndices.put("A28M", configuraArray(35,45,64,71,72));
		mapaIndices.put("A29M", configuraArray(35,45,63,71,72));
		mapaIndices.put("A30M", configuraArray(34,44,62,70,71));
		mapaIndices.put("A31M", configuraArray(33,42,60,69,70));
		mapaIndices.put("A32M", configuraArray(33,42,60,69,70));
		mapaIndices.put("A33M", configuraArray(32,41,60,69,70));
		mapaIndices.put("A34M", configuraArray(32,40,58,67,68));
		mapaIndices.put("A35M", configuraArray(30,39,56,65,66));
		mapaIndices.put("A36M", configuraArray(30,38,55,64,65));
		mapaIndices.put("A37M", configuraArray(29,38,55,64,65));
		mapaIndices.put("A38M", configuraArray(29,38,55,64,65));
		mapaIndices.put("A39M", configuraArray(29,38,54,63,64));
		mapaIndices.put("A40M", configuraArray(28,37,54,63,64));
		mapaIndices.put("A41M", configuraArray(28,37,53,62,63));
		mapaIndices.put("A42M", configuraArray(28,37,53,62,63));
		mapaIndices.put("A43M", configuraArray(27,36,52,61,62));
		mapaIndices.put("A44M", configuraArray(26,36,52,61,62));
		mapaIndices.put("A45M", configuraArray(26,34,50,59,60));
		mapaIndices.put("A46M", configuraArray(26,34,50,59,60));
		mapaIndices.put("A47M", configuraArray(25,33,48,57,58));
		mapaIndices.put("A48M", configuraArray(25,33,46,55,56));
		mapaIndices.put("A49M", configuraArray(24,32,45,53,54));
		mapaIndices.put("A50M", configuraArray(25,0,0,0,0));
		mapaIndices.put("A51M", configuraArray(24,0,0,0,0));
		mapaIndices.put("A52M", configuraArray(24,0,0,0,0));
		mapaIndices.put("A53M", configuraArray(23,0,0,0,0));
		mapaIndices.put("A54M", configuraArray(22,0,0,0,0));
		mapaIndices.put("A55M", configuraArray(21,0,0,0,0));
		mapaIndices.put("A56M", configuraArray(20,0,0,0,0));
		mapaIndices.put("A57M", configuraArray(19,0,0,0,0));
		mapaIndices.put("A58M", configuraArray(18,0,0,0,0));
		mapaIndices.put("A59M", configuraArray(17,0,0,0,0));
		mapaIndices.put("A60M", configuraArray(16,0,0,0,0));
		mapaIndices.put("A61M", configuraArray(15,0,0,0,0));
		mapaIndices.put("A62M", configuraArray(14,0,0,0,0));
		mapaIndices.put("A63M", configuraArray(13,0,0,0,0));
		mapaIndices.put("A64M", configuraArray(12,0,0,0,0));
		mapaIndices.put("A65M", configuraArray(11,0,0,0,0));
		
		mapaIndices.put("C18F", configuraArray(1899,2099,2399,2599,2600));
		mapaIndices.put("C19F", configuraArray(1899,2099,2399,2599,2600));
		mapaIndices.put("C20F", configuraArray(1849,2049,2349,2549,2550));
		mapaIndices.put("C21F", configuraArray(1849,2049,2349,2549,2550));
		mapaIndices.put("C22F", configuraArray(1849,2049,2349,2549,2550));
		mapaIndices.put("C23F", configuraArray(1849,2049,2349,2549,2550));
		mapaIndices.put("C24F", configuraArray(1799,1999,2299,2499,2500));
		mapaIndices.put("C25F", configuraArray(1799,1999,2299,2499,2500));
		mapaIndices.put("C26F", configuraArray(1799,1999,2299,2499,2500));
		mapaIndices.put("C27F", configuraArray(1799,1999,2299,2499,2500));
		mapaIndices.put("C28F", configuraArray(1749,1949,2249,2449,2450));
		mapaIndices.put("C29F", configuraArray(1749,1949,2249,2449,2450));
		mapaIndices.put("C30F", configuraArray(1749,1949,2249,2449,2450));
		mapaIndices.put("C31F", configuraArray(1699,1899,2199,2399,2400));
		mapaIndices.put("C32F", configuraArray(1699,1899,2199,2399,2400));
		mapaIndices.put("C33F", configuraArray(1699,1899,2199,2399,2400));
		mapaIndices.put("C34F", configuraArray(1699,1899,2199,2399,2400));
		mapaIndices.put("C35F", configuraArray(1649,1849,2149,2349,2350));
		mapaIndices.put("C36F", configuraArray(1649,1849,2149,2349,2350));
		mapaIndices.put("C37F", configuraArray(1649,1849,2149,2349,2350));
		mapaIndices.put("C38F", configuraArray(1649,1849,2149,2349,2350));
		mapaIndices.put("C39F", configuraArray(1599,1799,2099,2299,2300));
		mapaIndices.put("C40F", configuraArray(1599,1799,2099,2299,2300));
		mapaIndices.put("C41F", configuraArray(1599,1799,2099,2299,2300));
		mapaIndices.put("C42F", configuraArray(1599,1799,2099,2299,2300));
		mapaIndices.put("C43F", configuraArray(1549,1749,2049,2249,2250));
		mapaIndices.put("C44F", configuraArray(1549,1749,2049,2249,2250));
		mapaIndices.put("C45F", configuraArray(1549,1749,2049,2249,2250));
		mapaIndices.put("C46F", configuraArray(1549,1749,2049,2249,2250));
		mapaIndices.put("C47F", configuraArray(1499,1699,1999,2199,2200));
		mapaIndices.put("C48F", configuraArray(1499,1699,1999,2199,2200));
		mapaIndices.put("C49F", configuraArray(1499,1699,1999,2199,2200));
		mapaIndices.put("C50F", configuraArray(1500,0,0,0,0));
		mapaIndices.put("C51F", configuraArray(1450,0,0,0,0));
		mapaIndices.put("C52F", configuraArray(1450,0,0,0,0));
		mapaIndices.put("C53F", configuraArray(1450,0,0,0,0));
		mapaIndices.put("C54F", configuraArray(1450,0,0,0,0));
		mapaIndices.put("C55F", configuraArray(1400,0,0,0,0));
		mapaIndices.put("C56F", configuraArray(1400,0,0,0,0));
		mapaIndices.put("C57F", configuraArray(1400,0,0,0,0));
		mapaIndices.put("C58F", configuraArray(1350,0,0,0,0));
		mapaIndices.put("C59F", configuraArray(1350,0,0,0,0));
		mapaIndices.put("C60F", configuraArray(1350,0,0,0,0));
		
		mapaIndices.put("F18F", configuraArray(16,20,29,34,35));
		mapaIndices.put("F19F", configuraArray(16,20,29,34,35));
		mapaIndices.put("F20F", configuraArray(16,20,29,34,35));
		mapaIndices.put("F21F", configuraArray(15,19,28,33,34));
		mapaIndices.put("F22F", configuraArray(15,19,28,33,34));
		mapaIndices.put("F23F", configuraArray(15,19,28,33,34));
		mapaIndices.put("F24F", configuraArray(14,18,27,32,33));
		mapaIndices.put("F25F", configuraArray(14,18,27,32,33));
		mapaIndices.put("F26F", configuraArray(14,18,27,32,33));
		mapaIndices.put("F27F", configuraArray(14,18,27,32,33));
		mapaIndices.put("F28F", configuraArray(13,17,26,31,32));
		mapaIndices.put("F29F", configuraArray(13,17,26,31,32));
		mapaIndices.put("F30F", configuraArray(13,17,26,31,32));
		mapaIndices.put("F31F", configuraArray(12,16,25,30,31));
		mapaIndices.put("F32F", configuraArray(12,16,25,30,31));
		mapaIndices.put("F33F", configuraArray(12,16,25,30,31));
		mapaIndices.put("F34F", configuraArray(12,16,25,30,31));
		mapaIndices.put("F35F", configuraArray(11,15,24,29,30));
		mapaIndices.put("F36F", configuraArray(11,15,24,29,30));
		mapaIndices.put("F37F", configuraArray(11,15,24,29,30));
		mapaIndices.put("F38F", configuraArray(10,14,23,28,29));
		mapaIndices.put("F39F", configuraArray(10,14,23,28,29));
		mapaIndices.put("F40F", configuraArray(10,14,23,28,29));
		mapaIndices.put("F41F", configuraArray(10,14,23,28,29));
		mapaIndices.put("F42F", configuraArray(9,13,22,27,28));
		mapaIndices.put("F43F", configuraArray(9,13,22,27,28));
		mapaIndices.put("F44F", configuraArray(9,13,22,27,28));
		mapaIndices.put("F45F", configuraArray(8,12,21,26,27));
		mapaIndices.put("F46F", configuraArray(8,12,21,26,27));
		mapaIndices.put("F47F", configuraArray(8,12,21,26,27));
		mapaIndices.put("F48F", configuraArray(8,12,21,26,27));
		mapaIndices.put("F49F", configuraArray(7,11,20,25,26));
		mapaIndices.put("F50F", configuraArray(8,0,0,0,0));
		mapaIndices.put("F51F", configuraArray(8,0,0,0,0));
		mapaIndices.put("F52F", configuraArray(7,0,0,0,0));
		mapaIndices.put("F53F", configuraArray(7,0,0,0,0));
		mapaIndices.put("F54F", configuraArray(7,0,0,0,0));
		mapaIndices.put("F55F", configuraArray(7,0,0,0,0));
		mapaIndices.put("F56F", configuraArray(6,0,0,0,0));
		mapaIndices.put("F57F", configuraArray(6,0,0,0,0));
		mapaIndices.put("F58F", configuraArray(6,0,0,0,0));
		mapaIndices.put("F59F", configuraArray(5,0,0,0,0));
		mapaIndices.put("F60F", configuraArray(5,0,0,0,0));
		
		mapaIndices.put("A18F", configuraArray(32,41,57,66,67));
		mapaIndices.put("A19F", configuraArray(31,40,56,65,66));
		mapaIndices.put("A20F", configuraArray(31,40,56,65,66));
		mapaIndices.put("A21F", configuraArray(30,39,55,64,65));
		mapaIndices.put("A22F", configuraArray(30,39,55,64,65));
		mapaIndices.put("A23F", configuraArray(29,38,54,63,64));
		mapaIndices.put("A24F", configuraArray(29,38,54,63,64));
		mapaIndices.put("A25F", configuraArray(28,37,53,62,63));
		mapaIndices.put("A26F", configuraArray(28,37,53,62,63));
		mapaIndices.put("A27F", configuraArray(27,36,52,61,62));
		mapaIndices.put("A28F", configuraArray(27,36,52,61,62));
		mapaIndices.put("A29F", configuraArray(26,35,51,60,61));
		mapaIndices.put("A30F", configuraArray(25,34,50,59,60));
		mapaIndices.put("A31F", configuraArray(25,34,50,59,60));
		mapaIndices.put("A32F", configuraArray(24,33,49,58,59));
		mapaIndices.put("A33F", configuraArray(24,33,49,58,59));
		mapaIndices.put("A34F", configuraArray(23,32,48,57,58));
		mapaIndices.put("A35F", configuraArray(23,32,48,57,58));
		mapaIndices.put("A36F", configuraArray(22,31,47,56,57));
		mapaIndices.put("A37F", configuraArray(22,31,47,56,57));
		mapaIndices.put("A38F", configuraArray(21,30,46,55,56));
		mapaIndices.put("A39F", configuraArray(21,30,46,55,56));
		mapaIndices.put("A40F", configuraArray(20,29,45,54,55));
		mapaIndices.put("A41F", configuraArray(20,29,45,54,55));
		mapaIndices.put("A42F", configuraArray(19,28,44,53,54));
		mapaIndices.put("A43F", configuraArray(18,27,43,52,53));
		mapaIndices.put("A44F", configuraArray(18,27,43,52,53));
		mapaIndices.put("A45F", configuraArray(17,26,42,51,52));
		mapaIndices.put("A46F", configuraArray(17,26,42,51,52));
		mapaIndices.put("A47F", configuraArray(16,25,41,50,51));
		mapaIndices.put("A48F", configuraArray(16,25,41,50,51));
		mapaIndices.put("A49F", configuraArray(15,24,40,49,50));
		mapaIndices.put("A50F", configuraArray(160,0,0,0,0));
		mapaIndices.put("A51F", configuraArray(15,0,0,0,0));
		mapaIndices.put("A52F", configuraArray(15,0,0,0,0));
		mapaIndices.put("A53F", configuraArray(14,0,0,0,0));
		mapaIndices.put("A54F", configuraArray(13,0,0,0,0));
		mapaIndices.put("A55F", configuraArray(13,0,0,0,0));
		mapaIndices.put("A56F", configuraArray(12,0,0,0,0));
		mapaIndices.put("A57F", configuraArray(12,0,0,0,0));
		mapaIndices.put("A58F", configuraArray(11,0,0,0,0));
		mapaIndices.put("A59F", configuraArray(11,0,0,0,0));
		mapaIndices.put("A60F", configuraArray(10,0,0,0,0));
		
		return mapaIndices;
	}
	
	private static int[] configuraArray(int i1, int i2, int i3, int i4, int i5){
		
		int[] arrayAux = {i1, i2, i3, i4, i5};
		return arrayAux;
	}
	
}
