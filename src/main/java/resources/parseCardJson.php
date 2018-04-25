<?php
	$json = file_get_contents(__DIR__ . '/cards.json');
	$json = json_decode($json, true)['cards'];

	foreach ($json as $i => $card) {
		foreach ($card as $key => $value) {
			if (empty($value) || $key == 'action_desc') {
				unset($json[$i][$key]);
			}
			if (!in_array($key, array('card_type', 'action_desc'))) {
				if (in_array($key, array('desc', 'action_type'))) {
					$json[$i]['actions'][0][$key] = $value;
				} else {
					$json[$i]['actions'][0]['params'][$key] = $value;
				}
				unset($json[$i][$key]);
			}
		}
	}
	$json = json_encode($json, JSON_PRETTY_PRINT);
	echo $json;
	file_put_contents('cards.json', $json);
?>