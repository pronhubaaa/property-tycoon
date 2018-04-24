<?php
	$json = file_get_contents(__DIR__ . '/cards.json');
	$json = json_decode($json, true)['cards'];

	foreach ($json as $i => $card) {
		foreach ($card as $key => $value) {
			if (empty($value)) {
				unset($json[$i][$key]);
			}
		}
	}
	$json = json_encode($json, JSON_PRETTY_PRINT);
	file_put_contents('cards.json', $json);
?>