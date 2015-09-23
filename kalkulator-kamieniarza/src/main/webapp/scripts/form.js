$(document)
		.ready(
				function() {
					$('#wyniki').fadeOut();
					$('form').validate(
							{
								highlight : function(element, errorClass) {
									$(element).add($(element)).addClass(
											"invalidElem");
								},
								unhighlight : function(element, errorClass) {
									$(element).add($(element)).removeClass(
											"invalidElem");
								},
								errorElement : "div",
								errorClass : "errorMsg"
							});

					$.validator.addClassRules({
						validatorCen : {
							min : 0,
							max : 9999
						},
						validatorWymiarowMalych : {
							min : 2,
							max : 100
						},
						
						validatorWymiarowDuzych : {
							min : 30,
							max : 400
						},
						validatorGrubosci : {
							min : 2,
							max : 15
						}

					});

					$('.ceny').addClass("validatorCen").change(function(e) {
						$('form').validate().element($(e.target));
					});
					
					
					$('.grubosci').addClass("validatorGrubosci").change(function(e) {
						$('form').validate().element($(e.target));
					});
					
					$('.wymiary_male').addClass("validatorWymiarowMalych").change(function(e) {
						$('form').validate().element($(e.target));
					});
					
					$('.wymiary_duze').addClass("validatorWymiarowDuzych").change(function(e) {
						$('form').validate().element($(e.target));
					});

					
					var typCen = "Ceny Podstawowe";
					$('#ceny_za_metr').accordion({
						heightStyle : "content",
						activate : function(event, ui) {
							typCen = ui.newHeader.text();
							console.log(ui.newHeader.text());
						}

					});

					var wykonczenia = "proste";
					$("#wykonczenia").selectmenu({
						heightStyle : "content",
						change : function(event, data) {
							wykonczenia = data.item.value;
						}
					});

					var wykonczeniaNakrywyPrzod = "proste";
					$("#wykonczenia_nakrywy_przod").selectmenu({
						heightStyle : "content",
						change : function(event, data) {
							wykonczeniaNakrywyPrzod = data.item.value;
						}
					});

					var wykonczeniaOkladzin = "proste";
					$("#wykonczenia_okladzin").selectmenu({
						heightStyle : "content",
						change : function(event, data) {
							wykonczeniaOkladzin = data.item.value;
						}
					});

					var wykonczeniaOkladzinPrzod = "proste";
					$("#wykonczenia_okladzin_przod").selectmenu({
						heightStyle : "content",
						change : function(event, data) {
							wykonczeniaOkladzinPrzod = data.item.value;
						}
					});

					function getFormValues(typCen) {

						var tombstoneClient2 = {
							wzor : 'n1',
							ceny : {
								cenaPodstawowa : $('#cena_za_metr').val(),
								cenaOkladzin : $('#cena_za_metr_okldzin').val(),
								cenaScian : $('#cena_za_metr_scian').val(),
								cenaNakrywy : $('#cena_za_metr_nakrywy').val(),
								cenaGradusa : $('#cena_za_metr_gradus').val(),
								typCeny : typCen
							},
							grubosci : {
								gruboscOkladzin : $('#grubosc_okldzin').val(),
								gruboscScian : $('#grubosc_scian').val(),
								gruboscNakrywy : $('#grubosc_nakrywy').val(),
								gruboscGradusa : $('#grubosc_gradus').val()
							},
							wymiary : {
								wysokosc : $('#wusokosc_scian').val(),
								szerokosc : $('#szerokosc').val(),
								dlugosc : $('#dlugosc').val(),
								szerokoscGradusa : $('#szerokosc_gradusa').val(),
								okap : $('#okap').val(),
								wypustGradusa : $('#wypust_gradusa').val(),
								szerokoscDlugichOkladzin : $('#szerokosc_okladziny_dlugiej')
										.val(),
								szerokoscTylnejOkladziny : $(
										'#szerokosc_okladziny_tylnej').val(),
								szerokoscPrzedniejOkladziny : $(
										'#szerokosc_okladziny_przedniej').val()
							},
							wykomczenia : {
								wykonczenieNakrywy : wykonczenia,
								wykonczenieOkladzin : wykonczeniaOkladzin,
								profilNakrywy : wykonczeniaNakrywyPrzod,
								profilOkladzin : wykonczeniaOkladzinPrzod,
								cenaWykonczenieNakrywy : $('#cena_wykonczenia_nakrywy')
										.val(),
								cenaWykonczenieOkladzin : $('#cena_wykonczenia_okladzin')
										.val(),
								cenaProfilNakrywy : $('#cena_wykonczenia_nakrywy_z_przodu').val(),
								cenaProfilOkladzin : $('#cena_wykonczenia_okladzin_z_przodu').val()
							}

						};
						return tombstoneClient2;
					}

					$('#submit')
							.click(
									function(e) {
										
										console
												.log(JSON
														.stringify(getFormValues(typCen)));
									
										$
												.ajax({
													type : 'post',
													data : JSON
															.stringify(getFormValues(typCen)),
													contentType : 'application/json',
													url : 'http://localhost:8089/serv/calculate/tombstone?callback=?',

													success : processServerResponse
												});
										e.preventDefault();
									});

					function processServerResponse(data) {
						console
						.log(JSON
								.stringify(data));
						console
						.log(data.cena);
						$('form').fadeOut();
						$('#wyniki').fadeIn();
						$('#wynik_cena').text(data.cena);
						$('#wynik_zuzycie').text(data.zuzycie);
						$('#wynik_cwiercwalek').text(data.dlugoscCwiercwalka);
						$('#wynik_profilu').text(data.dlugoscProfilu);
						$('#wynik_nakrywa').text(data.zuzycieNakrywa);
						$('#wynik_nakrywa_cena').text(data.cenaNakrywa);
						
						$('#wynik_gradus').text(data.zuzycieGradus);
						$('#wynik_gradus_cena').text(data.cenaGradus);
						
						$('#wynik_scian').text(data.zuzycieScian);
						$('#wynik_scian_cena').text(data.cenaScian);
						
						$('#wynik_okladzin').text(data.zuzycieOkladzin);
						$('#wynik_okladzin_cena').text(data.cenaOkladzin);
					}
					
					$('#powrot').click(function(e) {
						$('form').fadeIn();
						$('#wyniki').fadeOut();
					});

				});